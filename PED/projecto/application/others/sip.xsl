<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl"
    exclude-result-prefixes="xs xd"
    version="1.0">
    <xd:doc scope="stylesheet">
        <xd:desc>
            <xd:p><xd:b>Created on:</xd:b> Oct 15, 2012</xd:p>
            <xd:p><xd:b>Author:</xd:b> anolsi</xd:p>
            <xd:p></xd:p>
        </xd:desc>
    </xd:doc>
    <xsl:output method="html" encoding="UTF-8" indent="yes" />
    
    <xsl:template match="/">
                <style type='text/css'>
                    #rptitle{
                        color:white !important;
                        width:95% !important;
                        height:50px !important;
                        text-align:center !important;
                        border-radius: 5px !important;
                        background-image: linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
                        background-image: -o-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
                        background-image: -moz-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
                        background-image: -webkit-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;
                        background-image: -ms-linear-gradient(top, rgb(54,111,180) 0%, rgb(0,42,89) 100%) !important;

                        background-image: -webkit-gradient(
                            linear,
                            left top,
                            left bottom,
                            color-stop(0, rgb(54,111,180)),
                            color-stop(1, rgb(0,42,89))
                        ) !important;
                        margin: auto !important;
                    }
                    .block{
                        border-color: rgb(54,111,180) !important;
                        border-style: ridge !important;
                        border-width: 3px !important;
                        border-radius: 5px !important;
                        box-shadow: 0px 0px 2px 2px rgb(0,42,89) !important;
                        padding: 5px !important;
                        vertical-align: top !important;
                    }	
                    #rptitle h1{
                        padding: 2px !important;
                    }
                    table{
                        width:95% !important;
                        border-spacing: 8px !important;
                        border-collapse: separate !important;
                        margin:auto !important;
                    }
                </style>
                <div id="rptitle"><h1>[<xsl:value-of select="sip/meta/titulo"/>]</h1></div>
                <table>
                    <tr>
                        <td style="width:70%; text-align: justify;" class="block" rowspan="4">
                            <xsl:choose>
								<xsl:when test="/sip/meta/subtitulo"><h2><xsl:value-of select="sip/meta/subtitulo"/></h2></xsl:when>
								<xsl:otherwise><h2>Resumo</h2></xsl:otherwise>
							</xsl:choose>
                            <xsl:apply-templates select="sip/resumo"/>
                        </td>
                    <!--<xsl:apply-templates select="sip/meta"/>-->
                    
                        <td style="width:30%;" class="block">
                            <xsl:if test="sip/meta/data-inic">
                                <b>Data de início: </b><xsl:value-of select="sip/meta/data-inic"/><br/>
                            </xsl:if>
                            <b>Data de fim: </b><xsl:value-of select="sip/meta/data-fim"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:30%;" class="block">
                            <h2>Autores:</h2>
                            <ul><xsl:apply-templates select="sip/meta/autores"/></ul>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:30%;" class="block">
                            <h2>Supervisores:</h2>
                            <ul><xsl:apply-templates select="sip/meta/supervisores"/></ul>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:30%;" class="block">
                            <h2>Resultados</h2>
                            <xsl:apply-templates select="sip/resultados"/>
                        </td>
                    </tr>
                </table>
    </xsl:template>
    
    <xsl:template match="meta">
                
    </xsl:template>
    
    <xsl:template match="supervisores">
        <li><xsl:apply-templates select="supervisor"/></li>
    </xsl:template>    
    
    <xsl:template match="supervisor">
        <b><xsl:value-of select="nome"/></b><br/>
        <ul>
            <xsl:if test="identificador"><li><b>Identificador: </b><xsl:value-of select="identificador"/></li></xsl:if>
            <xsl:if test="email"><li><b>E-mail: </b><a href="malito:{email}"><xsl:value-of select="email"/></a></li></xsl:if>
            <xsl:if test="web"><li><b>Web: </b><a href="{web}"><xsl:value-of select="web"/></a></li></xsl:if>
        </ul>
    </xsl:template>    
    
    <xsl:template match="autores">
        <li><xsl:apply-templates select="autor"/></li>
    </xsl:template>    
    
    <xsl:template match="autor">
        <b><xsl:value-of select="nome"/></b><br/>
        <ul>
            <xsl:if test="identificador"><li><b>Identificador: </b><xsl:value-of select="identificador"/></li></xsl:if>
            <xsl:if test="email"><li><b>E-mail: </b><a href="malito:{email}"><xsl:value-of select="email"/></a></li></xsl:if>
            <xsl:if test="web"><li><b>Web: </b><a href="{web}"><xsl:value-of select="web"/></a></li></xsl:if>
        </ul>
    </xsl:template>    
    
    
    <xsl:template match="resumo">
        <xsl:apply-templates/>
    </xsl:template>
    
    <xsl:template match="para">
        <p>
            <xsl:apply-templates />
        </p>
        
    </xsl:template>
    
    <xsl:template match="xref">
        <a href="{@url}">
            <xsl:value-of select="."/>
        </a>        
    </xsl:template>
    
    <xsl:template match="resultados">
        <ol>
            <xsl:apply-templates/>
        </ol>
    </xsl:template>
    
    <xsl:template match="resultado">
        <li>
            <a href="{@url}"><xsl:apply-templates/></a>
        </li>        
    </xsl:template>
    
</xsl:stylesheet>