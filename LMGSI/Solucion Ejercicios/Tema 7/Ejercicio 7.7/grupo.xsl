<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/grupo">
    <profesores>
    <xsl:copy-of select="//profesores"/>
    </profesores>
  </xsl:template>
</xsl:stylesheet>
