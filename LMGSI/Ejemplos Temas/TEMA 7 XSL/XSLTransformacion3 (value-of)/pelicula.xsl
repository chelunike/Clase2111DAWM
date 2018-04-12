<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method = "text" encoding = "UTF-8"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>          
          <xsl:value-of select="/pelicula/text()" />
        </title>
      </head>
      <body>
        <p>
          <b>Contenido del nodo película y descendientes:</b>
          <xsl:value-of select="/pelicula" />
        </p>
        <p>
          <b>Contenido del nodo actores y descendientes</b>
          <xsl:value-of select="/pelicula/actores" />
        </p>                  
      </body>
    </html>
  </xsl:template>  
  
</xsl:stylesheet>
