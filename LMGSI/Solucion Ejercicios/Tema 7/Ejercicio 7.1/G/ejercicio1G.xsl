<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="BBB">
    <div style="color:red">
      <xsl:value-of select="name()"/>
      <xsl:text> id=</xsl:text>
      <xsl:value-of select="@id"/>
      <xsl:value-of select="."/>
    </div>
  </xsl:template>
  
  <xsl:template match="/datos/AAA/CCC/DDD">
    <p style="color:blue"><xsl:value-of select="name()"/> 
                    id=<xsl:value-of select="@id"/> 
    </p>
  </xsl:template>
</xsl:stylesheet>
