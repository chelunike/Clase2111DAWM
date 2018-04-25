<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/animales">
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>
          <xsl:value-of select=".name()"/>
        </title>
      </head>
      <body>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:template>
  
  <xsl:template match="animal">
    <p><b>animal: <xsl:value-of select="@especie"/></b> se llama <xsl:value-of select="@nombre"/>, es de color <xsl:value-of select="datos/@color"/>, y pesa <xsl:value-of select="datos/@peso"/> </p>
  </xsl:template>
  
</xsl:stylesheet>
