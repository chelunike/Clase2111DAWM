<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <html>
      <head>
        <title>Informe de libros y editoriales</title>
      </head>
      <body bgcolor="#d2d2d2">
        <h2>Libros y editoriales</h2>
        <ol>
          <xsl:for-each select="/biblioteca/libro">
            <li>
              <xsl:value-of select="titulo"/>
              <xsl:text> (</xsl:text>
              <a>
                <xsl:attribute name="href">
                  <xsl:text>http://</xsl:text>
                  <xsl:value-of select="web"/>
                </xsl:attribute>
                <xsl:value-of select="editorial"/>
              </a>
              <xsl:text>)</xsl:text>
            </li>
          </xsl:for-each>
        </ol>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
