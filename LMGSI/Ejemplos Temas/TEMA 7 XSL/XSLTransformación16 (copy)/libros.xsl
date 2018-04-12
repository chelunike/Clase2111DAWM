<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <biblioteca>
      <xsl:apply-templates select="/biblioteca/libro"/>
    </biblioteca>
  </xsl:template>

  <xsl:template match="libro">
    <xsl:copy>
      <xsl:apply-templates select="autor"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="autor">
    <xsl:copy>
      <xsl:value-of select="."/>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>
