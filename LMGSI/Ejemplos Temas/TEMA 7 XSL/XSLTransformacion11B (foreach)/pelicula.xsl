<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <title>
					Información dobre la pelicula
					<xsl:value-of select="/pelicula/text()"/>.
				</title>
      </head>
      <body>
        <h1>
          <xsl:value-of select="/pelicula/text()"/>
        </h1>
        <h2>
          <b>Director:</b>
          <xsl:value-of select="/pelicula/director"/>
        </h2>
        <xsl:apply-templates select="/pelicula/actores"/>
      </body>
    </html>
  </xsl:template>
  
  <xsl:template match="actores">
    <b>Actores:</b>
    <xsl:for-each select="actor">
      <br/>
      <xsl:value-of select="nombre"/>
      <xsl:text> </xsl:text>
      <xsl:value-of select="apellidos"/>
    </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>
