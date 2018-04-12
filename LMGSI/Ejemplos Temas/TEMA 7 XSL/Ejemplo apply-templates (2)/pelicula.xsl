<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<head>
				<title>          
					<xsl:value-of select="/pelicula/text()" />
				</title>
			</head>
			<body>
				<p>
					<b>Pelicula:</b>
					<xsl:value-of select="/pelicula/text()" />
				</p>
				<p>
					<b>Director:</b>
					<xsl:value-of select="/pelicula/director/text()" />
				</p>
				<p>
					<b>Aplicamos reglas a los descendientes de pelicula</b>
					<xsl:apply-templates select="/pelicula" />
				</p>

			</body>
		</html>
	</xsl:template>

	<xsl:template match="actor">
		<br/>
		Contenido del nodo nombre y descendientes
		<xsl:value-of select="nombre"/>
	</xsl:template>

	<xsl:template match="vestuario">
		<br/>
		Contenido del nodo vestuario
		Vestuario: <xsl:value-of select="text()"/>
	</xsl:template>
  
</xsl:stylesheet>
