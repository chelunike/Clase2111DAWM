<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <html>
      <xsl:apply-templates select="liga"/>
    </html>
  </xsl:template>
  
  <xsl:template match="liga">
    <head>
      <meta charset="utf-8"/>
      <title>
        <xsl:value-of select="name(.)"/></title>
    </head>
    <body>
    <h1>Temporada: <xsl:value-of select="@temporada"/></h1>
     <table border="1">
        <tr>
          <th>nombre</th>
        <th>ganados</th>
          <th>empatados</th>
          <th>perdidos </th>
          <th>puntos</th>
          </tr>
        <xsl:apply-templates select="equipo"/>
        </table>
      </body>
      </xsl:template>
      
      <xsl:template match="equipo">
        <tr>
          <th><xsl:value-of select="@nombre"/></th>
          <td><xsl:value-of select="ganados/text()"/></td>
          <td><xsl:value-of select="empatados/text()"/></td>
          <td><xsl:value-of select="perdidos/text()"/></td>
          <td><xsl:value-of select="puntos/text()"/></td>
        </tr>
      </xsl:template>

</xsl:stylesheet>
