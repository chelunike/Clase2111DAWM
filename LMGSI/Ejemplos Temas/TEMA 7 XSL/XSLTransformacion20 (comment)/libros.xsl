<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <xsl:template match="biblioteca">
    <xsl:processing-instruction name="xml-stylesheet">
		    type= "text/xsl" href="libros_2.xsl"
 	  </xsl:processing-instruction>
    <xsl:copy>
      <xsl:element name="nombre">
        <xsl:attribute name="id">BP123-MA/GR</xsl:attribute>
        <xsl:attribute name="localidad">Marecena</xsl:attribute>
        <xsl:attribute name="cpostal">18200</xsl:attribute>
        		Publica de Maracena
      	</xsl:element>
        <xsl:comment>
        		Datos registrados de <xsl:value-of select="count(/biblioteca/libro)"/> libros
        </xsl:comment>
      <xsl:copy-of select="libro"/>
    </xsl:copy>
  </xsl:template>
  
</xsl:stylesheet>
