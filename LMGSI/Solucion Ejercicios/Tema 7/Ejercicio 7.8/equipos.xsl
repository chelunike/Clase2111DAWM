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
        <xsl:value-of select="name(.)"/>
      </title>
    </head>
    <body>
      <h1>Temporada: <xsl:value-of select="@temporada"/></h1>
      <table border="1">
        <tr>
          <th>Posicion</th>
          <th>nombre</th>
          <th>ganados</th>
          <th>empatados</th>
          <th>perdidos </th>
          <th>puntos</th>
        </tr>
        <xsl:for-each select="equipo">
          <xsl:sort select="puntos" order="descending" data-type="number"/>
          <tr>
            <td>
              <xsl:value-of select="position()"/>
            </td>
            <td>
              <em>
                <xsl:value-of select="@nombre"/>
              </em>
            </td>
            <td>
              <xsl:value-of select="ganados/text()"/>
            </td>
            <td>
              <xsl:value-of select="empatados/text()"/>
            </td>
            <td>
              <xsl:value-of select="perdidos/text()"/>
            </td>
            <td>
              <xsl:value-of select="puntos/text()"/>
            </td>
          </tr>
        </xsl:for-each>
      </table>
    </body>
  </xsl:template>
</xsl:stylesheet>
