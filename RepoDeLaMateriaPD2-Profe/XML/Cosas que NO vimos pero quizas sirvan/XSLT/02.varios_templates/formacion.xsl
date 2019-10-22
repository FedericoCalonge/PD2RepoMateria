<?xml version="1.0" encoding="UTF-8"?>
<!-- xsl stylesheet declaration with xsl namespace:
Namespace tells the xlst processor about which
element is to be processed and which is used for output purpose only
-->
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Jugadores</h2>
    <table border="1">
      <tr>
        <th>Camiseta</th>
        <th>Nombre</th>
      </tr>
      <xsl:apply-templates select="formacion/*">
        <xsl:sort select="@camiseta" />
      </xsl:apply-templates>
    </table>
  </body>
  </html>
</xsl:template>

<xsl:template match="arquero">
  <tr>
    <td><span style="color: green"><xsl:value-of select="@camiseta"/></span></td>
    <td><span style="color: green"><xsl:value-of select="text()"/></span></td>
  </tr>
</xsl:template>

<xsl:template match="defensor">
  <tr>
    <td><span style="color: red"><xsl:value-of select="@camiseta"/></span></td>
    <td><span style="color: red"><xsl:value-of select="text()"/></span></td>
  </tr>
</xsl:template>

<xsl:template match="medio">
  <tr>
    <td><span style="color: blue"><xsl:value-of select="@camiseta"/></span></td>
    <td><span style="color: blue"><xsl:value-of select="text()"/></span></td>
  </tr>
</xsl:template>


</xsl:stylesheet>
