<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
    <xsl:output method = "html" version="1.0" encoding = "UTF-8"/>
  
    <xsl:template match="/">
      <h2>
        Pelicula dirigida por <xsl:value-of select="pelicula/director"/>
      </h2>
      <p>Actores</p>
      <ol>
        <xsl:apply-templates select="pelicula/actores/actor" />
      </ol>
    </xsl:template>
    
    <xsl:template match="actor">
      <li>
        <xsl:value-of select="."/>
        (
        <xsl:value-of select="@papel"/>
        )
      </li>
    </xsl:template>
    
</xsl:stylesheet>
