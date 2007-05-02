<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{stats.page1}" id="page1">
            <ui:html binding="#{stats.html1}" id="html1">
                <ui:head binding="#{stats.head1}" id="head1">
                    <ui:link binding="#{stats.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{stats.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{stats.form1}" id="form1">
                        <ui:textArea binding="#{stats.textArea1}" id="textArea1" style="height: 96px; left: 24px; top: 24px; position: absolute"/>
                        <ui:button action="#{stats.button1_action}" binding="#{stats.button1}" id="button1" style="left: 23px; top: 144px; position: absolute" text="Continue"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
