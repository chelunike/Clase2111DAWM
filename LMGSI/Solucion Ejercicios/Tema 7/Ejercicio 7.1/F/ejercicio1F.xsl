<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="empleado">
    <p>
      <xsl:apply-templates select="nombre"/>
    </p>
    <p>
      <xsl:apply-templates select="apellidos"/>
    </p>
  </xsl:template>
  <xsl:template match="apellidos">
    <i>
      <xsl:value-of select="."/>
    </i>
  </xsl:template>
</xsl:stylesheet>
