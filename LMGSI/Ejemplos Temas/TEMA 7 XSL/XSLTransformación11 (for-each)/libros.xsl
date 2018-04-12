<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <html>
      <head>
        <title>Informe</title>
      </head>
      <body style="background-color:#D2D2D2">
        <h2>Informe de libros</h2>
        <hr/>
        <xsl:for-each select="/biblioteca/libro">
          <b>Titulo: </b>
          <i>
            <xsl:value-of select="titulo"/>
          </i>
          <br/>
          <b>Autor : </b>
          <i>
            <xsl:value-of select="autor"/>
          </i>
          <br/>
          <b>Editorial: </b>
          <i>
            <xsl:value-of select="editorial"/>
          </i>
          <hr/>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>
