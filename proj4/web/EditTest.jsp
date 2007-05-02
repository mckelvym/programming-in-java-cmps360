<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{EditTest.page1}" id="page1">
            <ui:html binding="#{EditTest.html1}" id="html1">
                <ui:head binding="#{EditTest.head1}" id="head1">
                    <ui:link binding="#{EditTest.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{EditTest.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{EditTest.form1}" id="form1">
                        <ui:staticText binding="#{EditTest.staticText1}" id="staticText1" style="position: absolute; left: 24px; top: 24px" text="Adding Questions to Test"/>
                        <ui:textArea binding="#{EditTest.question}" id="question" style="left: 24px; top: 72px; position: absolute; width: 288px"/>
                        <ui:label binding="#{EditTest.label1}" id="label1" style="left: 24px; top: 48px; position: absolute" text="Question"/>
                        <ui:staticText binding="#{EditTest.staticText2}" id="staticText2" style="position: absolute; left: 24px; top: 120px" text="Answer (a):"/>
                        <ui:staticText binding="#{EditTest.staticText3}" id="staticText3" style="left: 24px; top: 144px; position: absolute" text="Answer (b):"/>
                        <ui:staticText binding="#{EditTest.staticText4}" id="staticText4" style="left: 24px; top: 168px; position: absolute" text="Answer (c):"/>
                        <ui:staticText binding="#{EditTest.staticText5}" id="staticText5" style="left: 24px; top: 192px; position: absolute" text="Answer (d):"/>
                        <ui:textField binding="#{EditTest.a}" id="a" style="left: 96px; top: 120px; position: absolute; width: 216px"/>
                        <ui:textField binding="#{EditTest.b}" id="b" style="left: 96px; top: 144px; position: absolute; width: 216px"/>
                        <ui:textField binding="#{EditTest.c}" id="c" style="left: 96px; top: 168px; position: absolute; width: 216px"/>
                        <ui:textField binding="#{EditTest.d}" id="d" style="left: 96px; top: 192px; position: absolute; width: 216px"/>
                        <ui:staticText binding="#{EditTest.staticText6}" id="staticText6" style="left: 24px; top: 216px; position: absolute" text="Correct letter for answer:"/>
                        <ui:textField binding="#{EditTest.answer}" id="answer" style="left: 264px; top: 216px; position: absolute; width: 48px"/>
                        <ui:button action="#{EditTest.save_action}" binding="#{EditTest.save}" id="save" style="left: 215px; top: 24px; position: absolute" text="Save Question"/>
                        <ui:button action="#{EditTest.quit_action}" binding="#{EditTest.quit}" id="quit" style="left: 95px; top: 240px; position: absolute" text="Quit to Main Menu"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
