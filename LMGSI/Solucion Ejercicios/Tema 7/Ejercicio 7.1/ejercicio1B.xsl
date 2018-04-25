<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="negrita">
		<p>
			<b>
				<xsl:value-of select="."/>
			</b>
		</p>
	</xsl:template>
	<xsl:template match="rojo">
		<p style="color:red">
			<xsl:value-of select="."/>
		</p>
	</xsl:template>
	<xsl:template match="azul">
		<p style="color:blue">
			<xsl:value-of select="."/>
		</p>
	</xsl:template>
</xsl:stylesheet>