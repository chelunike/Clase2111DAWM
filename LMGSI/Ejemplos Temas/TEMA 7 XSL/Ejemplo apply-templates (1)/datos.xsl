<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet  version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="empleado">
    <em>
      <xsl:apply-templates select="nombre"/>
    </em>
    <b>
      <xsl:apply-templates select="apellido"/>
    </b>
  </xsl:template>

  <xsl:template match="apellido">
    <i>
      <xsl:value-of select="."/>
    </i>
  </xsl:template>
  
</xsl:stylesheet>
