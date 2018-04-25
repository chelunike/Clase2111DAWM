<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:template match="/">
    <xsl:element name="clasificacion">
      <xsl:apply-templates select="liga/equipo"/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="equipo">
    <xsl:copy>
      <xsl:element name="denominacion">
        <xsl:value-of select="@nombre"/>
      </xsl:element>
      <xsl:element name="jugados">
        <xsl:value-of select="empatados+ganados+perdidos"/>
      </xsl:element>
    </xsl:copy>
  </xsl:template>
  
</xsl:stylesheet>
