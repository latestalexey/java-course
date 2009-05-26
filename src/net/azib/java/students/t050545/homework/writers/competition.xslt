<?xml version="1.0" encoding="UTF-8"?><!--Designed and generated by Altova StyleVision Enterprise Edition 2009 - see http://www.altova.com/stylevision for more information.--><xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:link="http://www.xbrl.org/2003/linkbase" xmlns:xbrldi="http://xbrl.org/2006/xbrldi" xmlns:xbrli="http://www.xbrl.org/2003/instance" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:altova="http://www.altova.com" exclude-result-prefixes="fn link xbrldi xbrli xdt xlink xs xsi">	<xsl:output version="4.0" method="html" indent="no" encoding="UTF-8" doctype-public="-//W3C//DTD HTML 4.0 Transitional//EN" doctype-system="http://www.w3.org/TR/html4/loose.dtd"/>	<xsl:param name="SV_OutputFormat" select="'HTML'"/>	<xsl:variable name="XML" select="/"/>	<xsl:decimal-format name="format1" grouping-separator=" " decimal-separator=","/>	<xsl:template match="/">		<html>			<head>				<title/>			</head>			<body>				<xsl:for-each select="$XML">					<xsl:for-each select="competition">						<xsl:for-each select="@name">							<span>								<h1><xsl:value-of select="string(.)"/></h1>							</span>						</xsl:for-each>						<div>							<span>								<xsl:text>&#160;</xsl:text>							</span>						</div>						<xsl:for-each select="place">                                                        <hr/>							<h4><span>								<xsl:text>Place: </xsl:text>							</span>							<xsl:for-each select="@num">								<span>									<xsl:value-of select="string(.)"/>								</span>							</xsl:for-each> </h4>							<br/>							<xsl:for-each select="sportman">								<br/>								<span>									<xsl:text>Name: </xsl:text>								</span>								<xsl:for-each select="name">									<xsl:apply-templates/>								</xsl:for-each>								<br/>								<span>									<xsl:text>BirthDate: </xsl:text>								</span>								<xsl:for-each select="birthday">									<xsl:apply-templates/>								</xsl:for-each>								<br/>								<span>									<xsl:text>Country: </xsl:text>								</span>								<xsl:for-each select="country">									<xsl:apply-templates/>								</xsl:for-each>								<br/>								<span>									<xsl:text>Results:</xsl:text>								</span>								<br/>								<table style="border-bottom:1px; border-bottom-color:black; border-bottom-style:solid; border-top:1px; border-top-color:black; border-top-style:solid; " border="0px" width="100%">									<xsl:variable name="altova:CurrContextGrid" select="."/>									<thead>										<tr style="border-bottom:1px; border-bottom-color:black; border-bottom-style:solid; ">                                                                                        <th>											     <b><pre> </pre> </b>											</th>											<th>												<span>													<xsl:text>Race 100m</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Long jump</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Shot put</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>High jump</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Race 400m</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Hurdles 110m</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Discus throw</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Pole vault</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Javelin throw</xsl:text>												</span>											</th>											<th>												<span>													<xsl:text>Race 1500m</xsl:text>												</span>											</th>										</tr>									</thead>									<tbody>										<xsl:for-each select="resulttable">											<tr>                                                                                                <td> <i>results</i> </td>												<td>													<xsl:for-each select="Race_100m">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Long_jump">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Shot_put">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="High_jump">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Race_400m">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Hurdles_110m">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Discus_throw">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Pole_vault">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Javelin_throw">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Race_1500m">														<xsl:for-each select="result">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>											</tr>											<tr>                                                                                                <td> <i>points</i> </td>												<td>													<xsl:for-each select="Race_100m">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Long_jump">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Shot_put">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="High_jump">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Race_400m">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Hurdles_110m">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Discus_throw">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Pole_vault">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Javelin_throw">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>												<td>													<xsl:for-each select="Race_1500m">														<xsl:for-each select="score">															<span>																<xsl:value-of select="format-number(number(string(.)), '##0,00', 'format1')"/>															</span>														</xsl:for-each>													</xsl:for-each>												</td>											</tr>										</xsl:for-each>									</tbody>								</table>								<span>									<xsl:text><b>Total score: </b> </xsl:text>								</span>								<xsl:for-each select="resulttable">									<xsl:for-each select="total">										<xsl:apply-templates/>									</xsl:for-each>									<div>										<span>											<xsl:text>&#160;</xsl:text>										</span>									</div>								</xsl:for-each>								<br/>							</xsl:for-each>						</xsl:for-each>					</xsl:for-each>				</xsl:for-each>			</body>		</html>	</xsl:template></xsl:stylesheet>