<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/">
		<profesores>
			<xsl:apply-templates select="//profesor"/>
		</profesores>
	</xsl:template>
	<xsl:template match="profesor">
		<xsl:copy>
			<xsl:value-of select="."/>
		</xsl:copy>
	</xsl:template>
</xsl:stylesheet>