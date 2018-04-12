<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="/">
    <xsl:call-template name="ListaEditorial"/>
  </xsl:template>

  <xsl:template name="ListaEditorial">
    <p>
      <xsl:value-of select="biblioteca/libro/editorial"/>
    </p>
  </xsl:template>

</xsl:stylesheet>
