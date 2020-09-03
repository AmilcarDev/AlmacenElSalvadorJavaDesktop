-- MySQL Script generated by MySQL Workbench
-- 01/15/17 22:49:50
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BDAlmacen
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BDAlmacen` ;

-- -----------------------------------------------------
-- Schema BDAlmacen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BDAlmacen` DEFAULT CHARACTER SET utf8 ;
USE `BDAlmacen` ;

-- -----------------------------------------------------
-- Table `BDAlmacen`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`usuarios` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NULL,
  `nombres` VARCHAR(70) NULL,
  `apellidos` VARCHAR(70) NULL,
  `correo` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `usuario` VARCHAR(100) NULL,
  `clave` FLOAT NULL,
  `fecha` DATE NULL,
  `foto` LONGBLOB NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Usuario` (
  `Id_Usuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Estado` INT(11) NULL,
  `Correo` VARCHAR(45) NULL,
  `Empleados_Id_Empleados` INT(11) NOT NULL,
  PRIMARY KEY (`Id_Usuario`),
  INDEX `fk_Usuario_usuarios1_idx` (`Empleados_Id_Empleados` ASC),
  CONSTRAINT `fk_Usuario_usuarios1`
    FOREIGN KEY (`Empleados_Id_Empleados`)
    REFERENCES `BDAlmacen`.`usuarios` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Departamento` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Departamento` (
  `Id_Departamento` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`Id_Departamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Modelo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Modelo` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Modelo` (
  `Id_Modelo` INT NOT NULL,
  `Nombre_Modelo` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Modelo`),
  INDEX `fk_Modelo_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Modelo_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Color` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Color` (
  `Id_Color` INT NOT NULL,
  `Nombre_Color` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Color`),
  INDEX `fk_Color_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Color_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Categoria` (
  `Id_Categoria` INT NOT NULL,
  `Nombre_Categoria` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Categoria`),
  INDEX `fk_Categoria_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Categoria_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Estilo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Estilo` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Estilo` (
  `Id_Estilo` INT NOT NULL,
  `Nombre_Estilo` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Estilo`),
  INDEX `fk_Estilo_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Estilo_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Marca` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Marca` (
  `Id_Marca` INT NOT NULL,
  `Nombre_Marca` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Marca`),
  INDEX `fk_Marca_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Marca_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Talla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Talla` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Talla` (
  `Id_Talla` INT NOT NULL,
  `Nombre_Talla` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Talla`),
  INDEX `fk_Talla_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Talla_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Proveedor` (
  `Id_Proveedor` INT NOT NULL,
  `Nombre_Proveedor` VARCHAR(45) NULL,
  `Nombre_Representante` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  `Telefono_Encargado` VARCHAR(45) NULL,
  `Telefono_Empresa` VARCHAR(45) NULL,
  `Estado` VARCHAR(45) NULL,
  `foto` BLOB NULL,
  PRIMARY KEY (`Id_Proveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Producto` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Producto` (
  `Id_Producto` INT NOT NULL,
  `Nombre_Producto` VARCHAR(70) NULL,
  `Stock` INT NULL,
  `Id_Proveedor` INT NOT NULL,
  `Id_Departamento` INT NOT NULL,
  `Precio_unitario` FLOAT NULL,
  `Talla` VARCHAR(45) NULL,
  `Estilo` VARCHAR(45) NULL,
  `Marca` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `Categoria` VARCHAR(45) NULL,
  `Memoria_Interna` VARCHAR(45) NULL,
  `Memoria_Externa` VARCHAR(45) NULL,
  `Estado` VARCHAR(45) NULL,
  `Ganancia` INT NULL,
  `Clasificacion` VARCHAR(60) NULL,
  `Aroma` VARCHAR(45) NULL,
  `Contenido` VARCHAR(45) NULL,
  `Sistema` VARCHAR(45) NULL,
  `Modelo` VARCHAR(45) NULL,
  `foto` LONGBLOB NULL,
  `Tela` VARCHAR(45) NULL,
  `Cuello` VARCHAR(45) NULL,
  `Camara` VARCHAR(45) NULL,
  `Pantalla` VARCHAR(45) NULL,
  PRIMARY KEY (`Id_Producto`),
  INDEX `fk_Producto_Proveedor1_idx` (`Id_Proveedor` ASC),
  INDEX `fk_Producto_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Producto_Proveedor1`
    FOREIGN KEY (`Id_Proveedor`)
    REFERENCES `BDAlmacen`.`Proveedor` (`Id_Proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Compras` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Compras` (
  `Id_Compras` INT NOT NULL,
  `Numero_Factura` VARCHAR(45) NULL,
  `Tipo_Pago` VARCHAR(45) NULL,
  `Fecha_Compra` VARCHAR(45) NULL,
  `Fecha_Pago` VARCHAR(45) NULL,
  `Total` FLOAT NULL,
  `Id_Usuario` INT NOT NULL,
  `Id_Proveedor` INT NULL,
  PRIMARY KEY (`Id_Compras`),
  INDEX `fk_Compras_Usuario1_idx` (`Id_Usuario` ASC),
  CONSTRAINT `fk_Compras_Usuario1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `BDAlmacen`.`Usuario` (`Id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Clasificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Clasificacion` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Clasificacion` (
  `Id_Clasificacion` INT NOT NULL,
  `Nombre_Clasificacion` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Clasificacion`),
  INDEX `fk_Clasificacion_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Clasificacion_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Ventas` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Ventas` (
  `Id_Ventas` INT NOT NULL,
  `Fecha_Ventas` DATE NULL,
  `Usuario_Id_Usuario` INT NOT NULL,
  `Total` FLOAT NULL,
  PRIMARY KEY (`Id_Ventas`),
  INDEX `fk_Ventas_Usuario1_idx` (`Usuario_Id_Usuario` ASC),
  CONSTRAINT `fk_Ventas_Usuario1`
    FOREIGN KEY (`Usuario_Id_Usuario`)
    REFERENCES `BDAlmacen`.`Usuario` (`Id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Detalle_Compras_Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Detalle_Compras_Producto` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Detalle_Compras_Producto` (
  `Id_Detalle_Compras_Producto` INT NOT NULL,
  `Id_Compras` INT NOT NULL,
  `Id_Producto` INT NOT NULL,
  `Precio_Compra` FLOAT NULL,
  `Cantidad_Compra` INT NULL,
  INDEX `fk_Detalle_Compras_Producto_Compras1_idx` (`Id_Compras` ASC),
  INDEX `fk_Detalle_Compras_Producto_Producto1_idx` (`Id_Producto` ASC),
  PRIMARY KEY (`Id_Detalle_Compras_Producto`),
  CONSTRAINT `fk_Detalle_Compras_Producto_Compras1`
    FOREIGN KEY (`Id_Compras`)
    REFERENCES `BDAlmacen`.`Compras` (`Id_Compras`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Compras_Producto_Producto1`
    FOREIGN KEY (`Id_Producto`)
    REFERENCES `BDAlmacen`.`Producto` (`Id_Producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Inventario` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Inventario` (
  `Producto_Id_Producto` INT NOT NULL,
  `Cantidad` INT NULL,
  `Precio_Venta` FLOAT NULL,
  INDEX `fk_Inventario_Producto1_idx` (`Producto_Id_Producto` ASC),
  CONSTRAINT `fk_Inventario_Producto1`
    FOREIGN KEY (`Producto_Id_Producto`)
    REFERENCES `BDAlmacen`.`Producto` (`Id_Producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Bitacora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Bitacora` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Bitacora` (
  `idBitacora` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idBitacora`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`pass_recovery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`pass_recovery` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`pass_recovery` (
  `idpass_recovery` INT NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(45) NOT NULL,
  `time` TIMESTAMP NOT NULL,
  `Id_Usuario` INT NOT NULL,
  PRIMARY KEY (`idpass_recovery`),
  INDEX `fk_pass_recovery_Usuario1_idx` (`Id_Usuario` ASC),
  CONSTRAINT `fk_pass_recovery_Usuario1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `BDAlmacen`.`Usuario` (`Id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Contenido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Contenido` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Contenido` (
  `Id_Contenido` INT NOT NULL,
  `Nombre_Contenido` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Contenido`),
  INDEX `fk_Contenido_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Contenido_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Aroma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Aroma` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Aroma` (
  `Id_Aroma` INT NOT NULL,
  `Nombre_Aroma` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Aroma`),
  INDEX `fk_Aroma_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Aroma_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Sistema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Sistema` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Sistema` (
  `Id_Sistema` INT NOT NULL,
  `Nombre_Sistema` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Sistema`),
  INDEX `fk_Sistema_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Sistema_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Memoria_Interna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Memoria_Interna` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Memoria_Interna` (
  `Id_Memoria_Interna` INT NOT NULL,
  `Nombre_Memoria_Interna` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Memoria_Interna`),
  INDEX `fk_Memoria_Interna_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Memoria_Interna_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Memoria_Externa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Memoria_Externa` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Memoria_Externa` (
  `Id_Memoria_Externa` INT NOT NULL,
  `Nombre_Memoria_Externa` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Memoria_Externa`),
  INDEX `fk_Memoria_Externa_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Memoria_Externa_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Tela`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Tela` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Tela` (
  `Id_Tela` INT NOT NULL,
  `Nombre_Tela` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Tela`),
  INDEX `fk_Tela_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Tela_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Cuello`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Cuello` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Cuello` (
  `Id_Cuello` INT NOT NULL,
  `Nombre_Cuello` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Cuello`),
  INDEX `fk_Cuello_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Cuello_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`privilegios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`privilegios` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`privilegios` (
  `idprivilegios` INT(11) NOT NULL AUTO_INCREMENT,
  `reg_prov` TINYINT(1) NOT NULL DEFAULT '0',
  `reg_emp` TINYINT(1) NOT NULL DEFAULT '0',
  `reg_prod` TINYINT(1) NOT NULL DEFAULT '0',
  `reg_compras` TINYINT(1) NOT NULL DEFAULT '0',
  `reg_ventas` TINYINT(1) NOT NULL DEFAULT '0',
  `gen_report` TINYINT(1) NOT NULL DEFAULT '0',
  `con_inv` TINYINT(1) NOT NULL DEFAULT '0',
  `Usuario_Id_Usuario` INT(11) NOT NULL,
  PRIMARY KEY (`idprivilegios`, `Usuario_Id_Usuario`),
  INDEX `fk_privilegios_Usuario1_idx` (`Usuario_Id_Usuario` ASC),
  CONSTRAINT `fk_privilegios_Usuario1`
    FOREIGN KEY (`Usuario_Id_Usuario`)
    REFERENCES `BDAlmacen`.`Usuario` (`Id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Detalle_Ventas_has_Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Detalle_Ventas_has_Producto` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Detalle_Ventas_has_Producto` (
  `Id_Detalle_Ventas` INT NOT NULL,
  `Ventas_Id_Ventas` INT NOT NULL,
  `Producto_Id_Producto` INT NOT NULL,
  `Cantidad_Producto` INT NULL,
  `SubTotal` FLOAT NULL,
  PRIMARY KEY (`Id_Detalle_Ventas`),
  INDEX `fk_Detalle_Ventas_has_Producto_Ventas1_idx` (`Ventas_Id_Ventas` ASC),
  INDEX `fk_Detalle_Ventas_has_Producto_Producto1_idx` (`Producto_Id_Producto` ASC),
  CONSTRAINT `fk_Detalle_Ventas_has_Producto_Ventas1`
    FOREIGN KEY (`Ventas_Id_Ventas`)
    REFERENCES `BDAlmacen`.`Ventas` (`Id_Ventas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Ventas_has_Producto_Producto1`
    FOREIGN KEY (`Producto_Id_Producto`)
    REFERENCES `BDAlmacen`.`Producto` (`Id_Producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Camara`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Camara` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Camara` (
  `Id_Camara` INT NOT NULL,
  `Nombre_Camara` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Camara`),
  INDEX `fk_Camara_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Camara_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDAlmacen`.`Pantalla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDAlmacen`.`Pantalla` ;

CREATE TABLE IF NOT EXISTS `BDAlmacen`.`Pantalla` (
  `Id_Pantalla` INT NOT NULL,
  `Nombre_Pantalla` VARCHAR(45) NULL,
  `Id_Departamento` INT NOT NULL,
  PRIMARY KEY (`Id_Pantalla`),
  INDEX `fk_Pantalla_Departamento1_idx` (`Id_Departamento` ASC),
  CONSTRAINT `fk_Pantalla_Departamento1`
    FOREIGN KEY (`Id_Departamento`)
    REFERENCES `BDAlmacen`.`Departamento` (`Id_Departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;