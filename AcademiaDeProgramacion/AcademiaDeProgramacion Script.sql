USE [master]
GO
/****** Object:  Database [AcademiaDeProgramacion]    Script Date: 08/11/2020 14:56:39 ******/
CREATE DATABASE [AcademiaDeProgramacion]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AcademiaDeProgramacion', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\AcademiaDeProgramacion.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'AcademiaDeProgramacion_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\AcademiaDeProgramacion_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [AcademiaDeProgramacion] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AcademiaDeProgramacion].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AcademiaDeProgramacion] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET ARITHABORT OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET  ENABLE_BROKER 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET  MULTI_USER 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AcademiaDeProgramacion] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [AcademiaDeProgramacion] SET QUERY_STORE = OFF
GO
USE [AcademiaDeProgramacion]
GO
/****** Object:  Table [dbo].[Alumnos]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alumnos](
	[idAlumno] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](60) NULL,
	[apellido] [varchar](60) NULL,
	[sexo] [varchar](20) NULL,
	[fechaNacimiento] [varchar](25) NULL,
	[tipoDocumento] [varchar](40) NULL,
	[documento] [varchar](10) NULL,
	[direccion] [varchar](100) NULL,
	[telefono] [varchar](10) NULL,
	[email] [varchar](100) NULL,
 CONSTRAINT [pk_alumno] PRIMARY KEY CLUSTERED 
(
	[idAlumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cursos]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cursos](
	[idCurso] [int] IDENTITY(1,1) NOT NULL,
	[nombreCurso] [varchar](60) NULL,
	[idDocente] [int] NULL,
	[duracion] [varchar](100) NULL,
	[modalidad] [varchar](60) NULL,
	[precio] [real] NULL,
 CONSTRAINT [pk_curso] PRIMARY KEY CLUSTERED 
(
	[idCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Docentes]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Docentes](
	[idDocente] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](60) NULL,
	[apellido] [varchar](60) NULL,
	[legajo] [varchar](10) NULL,
	[correoInstitucional] [varchar](100) NULL,
 CONSTRAINT [pk_docente] PRIMARY KEY CLUSTERED 
(
	[idDocente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inscripcion]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inscripcion](
	[idInscripcion] [int] IDENTITY(1,1) NOT NULL,
	[idAlumno] [int] NULL,
	[idCurso] [int] NULL,
	[fechaInscripcion] [varchar](20) NULL,
	[legajo] [varchar](10) NULL,
	[idTurno] [int] NULL,
	[idPromocion] [int] NULL,
	[precioTotal] [real] NULL,
 CONSTRAINT [pk_inscripcion] PRIMARY KEY CLUSTERED 
(
	[idInscripcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notas]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notas](
	[idNota] [int] IDENTITY(1,1) NOT NULL,
	[idInscripcion] [int] NULL,
	[nombreNota] [varchar](25) NULL,
	[nota] [int] NULL,
 CONSTRAINT [pk_notas] PRIMARY KEY CLUSTERED 
(
	[idNota] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Programas]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Programas](
	[idPrograma] [int] IDENTITY(1,1) NOT NULL,
	[idAlumno] [int] NULL,
	[descripcion] [varchar](250) NULL,
	[nombrePrograma] [varchar](150) NULL,
	[estado] [int] NULL,
 CONSTRAINT [pk_programa] PRIMARY KEY CLUSTERED 
(
	[idPrograma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promociones]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promociones](
	[idPromocion] [int] IDENTITY(1,1) NOT NULL,
	[nombrePromocion] [varchar](150) NULL,
	[descuento] [float] NULL,
 CONSTRAINT [pk_promocion] PRIMARY KEY CLUSTERED 
(
	[idPromocion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Secretaria]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Secretaria](
	[idSecretaria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[apellido] [varchar](50) NULL,
	[correo] [varchar](100) NULL,
	[usuario] [varchar](50) NULL,
	[clave] [varchar](50) NULL,
 CONSTRAINT [pk_Secretaria] PRIMARY KEY CLUSTERED 
(
	[idSecretaria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Turnos]    Script Date: 08/11/2020 14:56:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Turnos](
	[idTurno] [int] IDENTITY(1,1) NOT NULL,
	[nombreTurno] [varchar](50) NULL,
	[horario] [varchar](50) NULL,
 CONSTRAINT [pk_turno] PRIMARY KEY CLUSTERED 
(
	[idTurno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Alumnos] ON 

INSERT [dbo].[Alumnos] ([idAlumno], [nombre], [apellido], [sexo], [fechaNacimiento], [tipoDocumento], [documento], [direccion], [telefono], [email]) VALUES (12, N'Nicolas David', N'Pedraza', N'Masculino', N'11/09/1999', N'Documento Unico de Identidad', N'42106261', N'Buchardo', N'3513460148', N'nicolasdpedraza@gmail.com')
INSERT [dbo].[Alumnos] ([idAlumno], [nombre], [apellido], [sexo], [fechaNacimiento], [tipoDocumento], [documento], [direccion], [telefono], [email]) VALUES (13, N'Juan Pablo', N'Pedraza', N'Masculino', N'17/01/2006', N'Documento Unico de Identidad', N'46311880', N'Buchardo', N'3518186812', N'juanpapedraza06@gmail.com')
INSERT [dbo].[Alumnos] ([idAlumno], [nombre], [apellido], [sexo], [fechaNacimiento], [tipoDocumento], [documento], [direccion], [telefono], [email]) VALUES (14, N'Alex', N'Alvarez', N'Masculino', N'17/06/2000', N'Documento Unico de Identidad', N'42524365', N'B Comercial', N'3513464825', N'alexealvarez@gmail.com')
INSERT [dbo].[Alumnos] ([idAlumno], [nombre], [apellido], [sexo], [fechaNacimiento], [tipoDocumento], [documento], [direccion], [telefono], [email]) VALUES (15, N'Cristian', N'Lencinas Luque', N'Masculino', N'26/04/2001', N'Documento Unico de Identidad', N'43545148', N'Juan de Garay 825', N'3513485848', N'cristianalencinas@gmail.com')
SET IDENTITY_INSERT [dbo].[Alumnos] OFF
GO
SET IDENTITY_INSERT [dbo].[Cursos] ON 

INSERT [dbo].[Cursos] ([idCurso], [nombreCurso], [idDocente], [duracion], [modalidad], [precio]) VALUES (2, N'C#', 3, N'Un Semestre', N'Presencial', 2000)
INSERT [dbo].[Cursos] ([idCurso], [nombreCurso], [idDocente], [duracion], [modalidad], [precio]) VALUES (3, N'Java', 1, N'Dos Semestre', N'Semi Presencial', 5000)
INSERT [dbo].[Cursos] ([idCurso], [nombreCurso], [idDocente], [duracion], [modalidad], [precio]) VALUES (4, N'HTML,CSS,JavaScript', 3, N'Dos Semestre', N'Semi Presencial', 6500)
INSERT [dbo].[Cursos] ([idCurso], [nombreCurso], [idDocente], [duracion], [modalidad], [precio]) VALUES (5, N'SQL Server', 4, N'1 Semestre', N'Presencial', 3500)
INSERT [dbo].[Cursos] ([idCurso], [nombreCurso], [idDocente], [duracion], [modalidad], [precio]) VALUES (6, N'Transact-SQL', 5, N'2 Semestre', N'Virtual', 4500)
SET IDENTITY_INSERT [dbo].[Cursos] OFF
GO
SET IDENTITY_INSERT [dbo].[Docentes] ON 

INSERT [dbo].[Docentes] ([idDocente], [nombre], [apellido], [legajo], [correoInstitucional]) VALUES (1, N'Martin', N'Navarro', N'241221', N'mnvarro@frc.utn.edu.ar')
INSERT [dbo].[Docentes] ([idDocente], [nombre], [apellido], [legajo], [correoInstitucional]) VALUES (3, N'Diego Javier', N'Serrano', N'130110', N'djserrano@frc.utn.edu.ar')
INSERT [dbo].[Docentes] ([idDocente], [nombre], [apellido], [legajo], [correoInstitucional]) VALUES (4, N'Beatriz', N'kunda', N'425351', N'bkunda@frc.utn.edu.ar')
INSERT [dbo].[Docentes] ([idDocente], [nombre], [apellido], [legajo], [correoInstitucional]) VALUES (5, N'Oscar', N'Botta', N'115226', N'obotta@frc.utn.edu.ar')
SET IDENTITY_INSERT [dbo].[Docentes] OFF
GO
SET IDENTITY_INSERT [dbo].[Inscripcion] ON 

INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (3, 14, 3, N'02/11/20', N'110130', 2, 3, 3250)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (4, 14, 6, N'05/11/2020', N'132121', 1, 3, 4225)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (5, 15, 5, N'05/11/2020', N'128553', 1, 4, 2957.5)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (6, 13, 4, N'05/11/2020', N'698123', 2, 5, 5200)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (7, 12, 3, N'05/11/2020', N'110130', 2, 1, 3750)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (8, 14, 4, N'06/11/2020', N'132121', 2, 1, 4875)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (9, 13, 5, N'06/11/2020', N'135146', 2, 5, 3480)
INSERT [dbo].[Inscripcion] ([idInscripcion], [idAlumno], [idCurso], [fechaInscripcion], [legajo], [idTurno], [idPromocion], [precioTotal]) VALUES (10, 12, 2, N'05/11/2020', N'110130', 1, 6, 2000)
SET IDENTITY_INSERT [dbo].[Inscripcion] OFF
GO
SET IDENTITY_INSERT [dbo].[Notas] ON 

INSERT [dbo].[Notas] ([idNota], [idInscripcion], [nombreNota], [nota]) VALUES (1, 10, N'Primer Parcial', 9)
INSERT [dbo].[Notas] ([idNota], [idInscripcion], [nombreNota], [nota]) VALUES (2, 10, N'Segundo Parcial', 9)
SET IDENTITY_INSERT [dbo].[Notas] OFF
GO
SET IDENTITY_INSERT [dbo].[Programas] ON 

INSERT [dbo].[Programas] ([idPrograma], [idAlumno], [descripcion], [nombrePrograma], [estado]) VALUES (1, 12, N'DBAcademiaDeProgramacion', N'Academia de Programacion.txt', 1)
INSERT [dbo].[Programas] ([idPrograma], [idAlumno], [descripcion], [nombrePrograma], [estado]) VALUES (2, 12, N'Capturas de pantallas de Prototipos de Easy', N'formRegistrarCliente.png', 1)
INSERT [dbo].[Programas] ([idPrograma], [idAlumno], [descripcion], [nombrePrograma], [estado]) VALUES (3, 12, N'Capturas de pantallas Listado de nota', N'ListadoNota.png', 0)
SET IDENTITY_INSERT [dbo].[Programas] OFF
GO
SET IDENTITY_INSERT [dbo].[Promociones] ON 

INSERT [dbo].[Promociones] ([idPromocion], [nombrePromocion], [descuento]) VALUES (1, N'Promocion de marzo', 25)
INSERT [dbo].[Promociones] ([idPromocion], [nombrePromocion], [descuento]) VALUES (3, N'Promocion de diciembre', 35)
INSERT [dbo].[Promociones] ([idPromocion], [nombrePromocion], [descuento]) VALUES (4, N'Promocion de febrero', 15.5)
INSERT [dbo].[Promociones] ([idPromocion], [nombrePromocion], [descuento]) VALUES (5, N'Promocion de noviembre', 20)
INSERT [dbo].[Promociones] ([idPromocion], [nombrePromocion], [descuento]) VALUES (6, N'Ninguna', 0)
SET IDENTITY_INSERT [dbo].[Promociones] OFF
GO
SET IDENTITY_INSERT [dbo].[Secretaria] ON 

INSERT [dbo].[Secretaria] ([idSecretaria], [nombre], [apellido], [correo], [usuario], [clave]) VALUES (1, N'Jose', N'Sfreddo', N'jsfreddo@frc.utn.edu.ar', N'josesfreddo', N'jose123')
SET IDENTITY_INSERT [dbo].[Secretaria] OFF
GO
SET IDENTITY_INSERT [dbo].[Turnos] ON 

INSERT [dbo].[Turnos] ([idTurno], [nombreTurno], [horario]) VALUES (1, N'2W1', N'8hs a 12hs')
INSERT [dbo].[Turnos] ([idTurno], [nombreTurno], [horario]) VALUES (2, N'2W2', N'19:30hs a 22:30hs')
SET IDENTITY_INSERT [dbo].[Turnos] OFF
GO
ALTER TABLE [dbo].[Cursos]  WITH CHECK ADD  CONSTRAINT [fk_curso_docentes] FOREIGN KEY([idDocente])
REFERENCES [dbo].[Docentes] ([idDocente])
GO
ALTER TABLE [dbo].[Cursos] CHECK CONSTRAINT [fk_curso_docentes]
GO
ALTER TABLE [dbo].[Inscripcion]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion_alumno] FOREIGN KEY([idAlumno])
REFERENCES [dbo].[Alumnos] ([idAlumno])
GO
ALTER TABLE [dbo].[Inscripcion] CHECK CONSTRAINT [fk_inscripcion_alumno]
GO
ALTER TABLE [dbo].[Inscripcion]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion_curso] FOREIGN KEY([idCurso])
REFERENCES [dbo].[Cursos] ([idCurso])
GO
ALTER TABLE [dbo].[Inscripcion] CHECK CONSTRAINT [fk_inscripcion_curso]
GO
ALTER TABLE [dbo].[Inscripcion]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion_promocion] FOREIGN KEY([idPromocion])
REFERENCES [dbo].[Promociones] ([idPromocion])
GO
ALTER TABLE [dbo].[Inscripcion] CHECK CONSTRAINT [fk_inscripcion_promocion]
GO
ALTER TABLE [dbo].[Inscripcion]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion_turno] FOREIGN KEY([idTurno])
REFERENCES [dbo].[Turnos] ([idTurno])
GO
ALTER TABLE [dbo].[Inscripcion] CHECK CONSTRAINT [fk_inscripcion_turno]
GO
ALTER TABLE [dbo].[Notas]  WITH CHECK ADD  CONSTRAINT [fk_notas_inscripcion] FOREIGN KEY([idInscripcion])
REFERENCES [dbo].[Inscripcion] ([idInscripcion])
GO
ALTER TABLE [dbo].[Notas] CHECK CONSTRAINT [fk_notas_inscripcion]
GO
ALTER TABLE [dbo].[Programas]  WITH CHECK ADD  CONSTRAINT [fk_programa_inscripcion] FOREIGN KEY([idAlumno])
REFERENCES [dbo].[Alumnos] ([idAlumno])
GO
ALTER TABLE [dbo].[Programas] CHECK CONSTRAINT [fk_programa_inscripcion]
GO
USE [master]
GO
ALTER DATABASE [AcademiaDeProgramacion] SET  READ_WRITE 
GO
