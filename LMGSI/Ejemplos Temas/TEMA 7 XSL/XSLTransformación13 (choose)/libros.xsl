<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <html>
      <xsl:apply-templates select="biblioteca"/>
    </html>
  </xsl:template>

  <xsl:template match="biblioteca">
    <head>
      <title>Libros</title>
    </head>
    <body style="background-color:#FAFAFA">
      <h2>Listado Libros</h2>
      <xsl:apply-templates select="libro"/>
    </body>
  </xsl:template>

  <xsl:template match="libro">
    <xsl:choose>
      <xsl:when test="editorial = 'Ra-Ma'">
        <p style="color:blue;">
          <xsl:value-of select="."/>
        </p>
      </xsl:when>
      <xsl:when test="editorial = 'McGraw-Hill'">
        <p style="color:red;">
          <xsl:value-of select="."/>
        </p>
      </xsl:when>
      <xsl:otherwise>
        <p style="color:green;">
          <xsl:value-of select="."/>
        </p>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  
</xsl:stylesheet>
