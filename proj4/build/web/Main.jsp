<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{Main.page1}" id="page1">
            <ui:html binding="#{Main.html1}" id="html1">
                <ui:head binding="#{Main.head1}" id="head1">
                    <ui:link binding="#{Main.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{Main.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{Main.form1}" id="form1">
                        <ui:staticText binding="#{Main.staticText1}" id="staticText1" style="left: 24px; top: 24px; position: absolute" text="Testing Management System"/>
                        <ui:button action="#{Main.button1_action}" binding="#{Main.button1}" id="button1"
                            style="left: 23px; top: 48px; position: absolute; width: 168px" text="Add questions to the Test"/>
                        <ui:button action="#{Main.button2_action}" binding="#{Main.button2}" id="button2"
                            style="left: 23px; top: 72px; position: absolute; width: 168px" text="Administer Test"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
