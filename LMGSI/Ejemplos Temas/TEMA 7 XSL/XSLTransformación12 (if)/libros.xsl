<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <html>
      <xsl:apply-templates select="biblioteca"/>
    </html>
  </xsl:template>

  <xsl:template match="biblioteca">
    <head>
      <title>Libros gordos</title>
    </head>
    <body style="background-color:#FAFAFA">
      <h2>Libros tochos</h2>
      <p>Los libros que tienen más de 900 páginas son:</p>
      <ol>
        <xsl:apply-templates select="libro"/>
      </ol>
    </body>
  </xsl:template>

  <xsl:template match="libro">
    <xsl:if test="paginas &gt; 900">
        <li>
          <b><xsl:value-of select="titulo"/></b>
          (<i><xsl:value-of select="autor"/></i>):
          <xsl:value-of select="paginas"/> págs.
      	</li>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>
