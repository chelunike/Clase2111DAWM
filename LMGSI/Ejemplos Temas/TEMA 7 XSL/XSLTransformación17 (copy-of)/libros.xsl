<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <libreria>
      <xsl:copy-of select="biblioteca/libro/titulo"/>
    </libreria>
  </xsl:template>

<!--
  <xsl:template match="biblioteca">
    <xsl:copy-of select="libro"/>
  </xsl:template>
  -->
</xsl:stylesheet>
