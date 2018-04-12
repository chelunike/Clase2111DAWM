<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <html>
      <head>
        <title>Tabla ordenada de libros</title>
      </head>
      <xsl:apply-templates select="biblioteca"/>
    </html>
  </xsl:template>

  <xsl:template match="biblioteca">
    <body style="background-color:#FAFAFA">
      <h2 style="text-align:center;">Listado de libros ordenados por número de páginas.</h2>
      <table align="center" border="2">
        <tr style="background-color:#FFFF00">
          <th>Titulo</th>
          <th>Autor</th>
          <th>Editorial</th>
          <th>Paginas</th>
          <th>Precio</th>
          <th>Prestado</th>
        </tr>
        <xsl:for-each select="libro">
          <xsl:sort select="paginas" order="ascending"/>
          <tr>
            <td>
              <xsl:value-of select="titulo"/>
            </td>
            <td>
              <xsl:value-of select="autor"/>
            </td>
            <td>
              <xsl:value-of select="editorial"/>
            </td>
            <td>
              <xsl:value-of select="paginas"/>
            </td>
            <td>
              <xsl:value-of select="precio"/>
            </td>
            <td style="text-align:center;">
              <xsl:if test="@prestado='SI'">
                <b style="color:#00FF00;">
                  <xsl:value-of select="@prestado"/>
                </b>
              </xsl:if>
              <xsl:if test="@prestado='NO'">
                <b style="color:#FF0000;">
                  <xsl:value-of select="@prestado"/>
                </b>
              </xsl:if>
            </td>
          </tr>
        </xsl:for-each>
      </table>
    </body>
  </xsl:template>
  
</xsl:stylesheet>
