CREATE DATABASE DemoAgenda;
USE DemoAgenda;
GO

CREATE TABLE [dbo].[contactos2](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [varchar](30) NULL,
	[apellidos] [varchar](50) NULL,
	[celular] [varchar](10) NULL,
	[email] [varchar](70) NULL,
	[direccion] [varchar](100) NULL,
	[estado] [int] NULL,
 CONSTRAINT [PK_contactos] PRIMARY KEY CLUSTERED ([id] ASC)
) ON [PRIMARY]
GO
