<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:q="urn:stock-quotes">
  <xsl:template match="/">
    <html>
      <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
      </head>
      <body>
        <xsl:apply-templates select="q:StockQuotes"/>
      </body>
    </html>
  </xsl:template>


  <xsl:template match="q:StockQuotes">
    <h1>Your Stock Quotes</h1>
    <table>
      <tr>
        <th>Quote Time</th>
        <th>Current</th>
        <th>Change</th>
      </tr>
      <xsl:apply-templates select="q:StockQuote"/>
    </table>
  </xsl:template>
  <xsl:template match="q:StockQuote">
    <tr>
      <td colspan="3" class="divisorRow">
        <xsl:value-of select="q:Symbol"/>
      </td>
    </tr>
    <xsl:apply-templates select="q:Quote"/>
  </xsl:template>
  <xsl:template match="q:Quote">
    <tr>
      <td><xsl:value-of select="@Time"/></td>
      <td><xsl:value-of select="q:Current"/></td>
      <td><xsl:value-of select="q:Change"/></td>
    </tr>
  </xsl:template>
</xsl:stylesheet>
