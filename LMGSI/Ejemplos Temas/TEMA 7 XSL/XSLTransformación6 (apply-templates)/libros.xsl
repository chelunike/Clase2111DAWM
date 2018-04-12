<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:template match="/">
    <h2>LISTA DE EDITORIALES</h2>
    <xsl:apply-templates />
    <hr/>
  </xsl:template>

  <xsl:template match="libro">
    <p>
      <xsl:value-of select="editorial" />
    </p>
  </xsl:template>
</xsl:stylesheet>