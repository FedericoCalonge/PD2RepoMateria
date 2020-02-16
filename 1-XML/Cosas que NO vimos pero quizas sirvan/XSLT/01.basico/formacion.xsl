<?xml version="1.0" encoding="UTF-8"?>
<!-- xsl stylesheet declaration with xsl namespace:
Namespace tells the xlst processor about which
element is to be processed and which is used for output purpose only
-->
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fcion="urn:xlmns:fcion">

<xsl:template match="/">

  <!-- los tags HTML el procesador XSLT los va a ignorar -->
  <html>
  <body>
  <h2>Jugadores</h2>
    <table border="1">
      <tr>
        <th>Camiseta</th>
        <th>Nombre</th>
      </tr>
    <xsl:for-each select="fcion:formacion/*">
    <tr>
      <td><xsl:value-of select="@camiseta"/></td>
      <td><xsl:value-of select="text()"/></td>
    </tr>
    </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>


</xsl:stylesheet>
