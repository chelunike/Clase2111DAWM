<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>
					<xsl:value-of select="/pelicula/text()" />
				</title>
			</head>
			<body>
				<h1>
					<xsl:value-of select="/pelicula/text()" />
				</h1>
				<b>Director:</b>
				<xsl:value-of select="/pelicula/director" />
				<br/>
				<b>Protagonista:</b>
				<xsl:value-of select="/pelicula/actores/actor" />
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>