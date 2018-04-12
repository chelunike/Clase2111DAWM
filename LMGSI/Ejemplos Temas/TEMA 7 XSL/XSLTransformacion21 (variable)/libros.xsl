<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:variable name="plantillaHTML">
    <html>
      <head>
        <title>Informe</title>
      </head>
      <body>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:variable>
  
  <xsl:template match="/">
    <xsl:copy-of select="$plantillaHTML"/>
  </xsl:template>

  <xsl:template match="biblioteca">
    <xsl:variable name="suma" select="sum(libro/paginas)"/>
    <p>Nº total de páginas de los libros: <xsl:value-of select="$suma"/></p>
  </xsl:template>
  
</xsl:stylesheet>
