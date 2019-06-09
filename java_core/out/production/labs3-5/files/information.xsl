<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/director">
        <html>
            <body>
                <table border="1">
                    <thead>
                        <tr>
                            <th>surname</th>
                            <th>name</th>
                            <th>patronymic</th>
                            <th>salary</th>
                            <th>experience</th>
                        </tr>
                    </thead>
                    <xsl:for-each select="worker">
                        <tr>
                            <xsl:call-template name="PrintStudent"/>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="PrintStudent">
        <td>
            <xsl:value-of select="surname"/>
        </td>
        <td>
            <xsl:value-of select="name"/>
        </td>
        <td>
            <xsl:value-of select="patronymic"/>
        </td>
        <td>
            <xsl:value-of select="salary"/>
        </td>
        <td>
            <xsl:value-of select="experience"/>
        </td>
    </xsl:template>
</xsl:stylesheet>