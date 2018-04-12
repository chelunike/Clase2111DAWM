<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" 
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<head>
				<title>Lista de libros</title>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

	<xsl:template match="biblioteca">
		<h2>Mis librillos:</h2>
		<xsl:apply-templates />
		<hr/>
	</xsl:template>

	<xsl:template match="libro">
		<p>
			<b>Autor: </b><xsl:apply-templates select="autor"/>      
			<b>. Título: </b><xsl:apply-templates select="titulo"/>
		</p>
	</xsl:template>

	<xsl:template match="titulo">
		<span style="color:#0000FF">
			<xsl:value-of select="." />
		</span>
	</xsl:template>

	<xsl:template match="autor">
		<span style="color:#FF0000">
			<xsl:value-of select="." />
		</span>
	</xsl:template>

</xsl:stylesheet>