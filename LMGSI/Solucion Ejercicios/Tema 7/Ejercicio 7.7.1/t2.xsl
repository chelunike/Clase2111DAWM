<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
		<profesores>
			<xsl:attribute name="nombre-grupo">
				<xsl:value-of select="grupo/nombre"/>
			</xsl:attribute>
			<xsl:apply-templates select="//profesor[../horas='6' and string-length(../codigo)=3]"/>
		</profesores>
	</xsl:template>
	<xsl:template match="profesor">
		<profesor>
			<xsl:attribute name="codigo">
				<xsl:value-of select="codigo"/>
			</xsl:attribute>
			<xsl:attribute name="especialidad">
				<xsl:value-of select="especialidad"/>
			</xsl:attribute>
		</profesor>
	</xsl:template>
</xsl:stylesheet>