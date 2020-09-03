package com.integra.backup;

import com.Conexion;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

public class BackupMySQL {
    private static String srcMysql="datos/database_utilities/mysql/";

    Properties propiedades;
    //para conectar con MySql
    protected static String user = "root";
    protected static String password = "";
    protected static String MySQL_Dir = "%MySQL%/bin/";
    protected static String db = "bdalmacen";
    private static String port = "3306";
    private static String host = "127.0.0.1";
    //para guardar en memmoria
    private static final int BUFFER = 10485760;
    private static StringBuffer temp = null;
    //para guardar el archivo SQL
    private static FileWriter fichero = null;
    private static PrintWriter pw = null;
    private Conexion con = new Conexion();

        
    public BackupMySQL() {
        
  Conexion con = new Conexion();
    }
     public void backup() {
        try {
            //sentencia para crear el BackUp
            Process run = Runtime.getRuntime().exec(srcMysql + "mysqldump --host=" + host + " --port=" + port
                    + " --user=" + user + " --password=" + password
                    + " " + db);
            //se guarda en memoria el backup
            new HiloLector(run.getErrorStream()).start();
            InputStream in = run.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            temp = new StringBuffer();
            int count;
            char[] cbuf = new char[BUFFER];
            while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
                temp.append(cbuf, 0, count);
            }
            br.close();
            in.close();
            /* se crea y escribe el archivo SQL */
            int a = 96;
            fichero = new FileWriter("datos/backups/backupalmacen&"+new String(new Date().toString()).replace(" ", "_").replace(":", "-")+".sql");
            pw = new PrintWriter(fichero);
            String addSqlString = "CREATE DATABASE  IF NOT EXISTS " + ((char) a) + db + ((char) a) + " /*!40100 DEFAULT CHARACTER SET utf8 */;\nUSE " + (char) a + db + (char) a + ";";
            pw.println(addSqlString);
            pw.println(temp.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void restore(String file) {
        try {
           // con.dropBD();
            con.createBD();
            Process run = Runtime.getRuntime().exec(srcMysql + "mysql "
                    + " --user=" + user + " --password=" + password + " " + db + " < " + file);
            System.out.println("La base de datos ha sido restaurada");

        } catch (IOException ex) {
            System.out.println("Errrorr al restaurar la base de datos: "+ex.getMessage());
        }
    }
    



//    public static void main(String[] args) {
//       backup();
//        //restore();
//    }

    static class HiloLector extends Thread {

        private InputStream is;

        public HiloLector(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1000];
                int leido = is.read(buffer);
                while (leido > 0) {
                    String texto = new String(buffer, 0, leido);
                    System.out.print(texto);
                    leido = is.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
