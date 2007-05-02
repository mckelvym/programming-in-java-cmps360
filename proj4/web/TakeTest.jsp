<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{TakeTest.page1}" id="page1">
            <ui:html binding="#{TakeTest.html1}" id="html1">
                <ui:head binding="#{TakeTest.head1}" id="head1">
                    <ui:link binding="#{TakeTest.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{TakeTest.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{TakeTest.form1}" id="form1">
                        <ui:staticText binding="#{TakeTest.staticText1}" id="staticText1" style="position: absolute; left: 24px; top: 24px" text="Testing Student"/>
                        <ui:staticText binding="#{TakeTest.staticText2}" id="staticText2" style="left: 24px; top: 48px; position: absolute" text="Question #"/>
                        <ui:button action="#{TakeTest.next_action}" binding="#{TakeTest.next}" id="next" style="left: 191px; top: 24px; position: absolute" text="Next"/>
                        <ui:staticText binding="#{TakeTest.staticText3}" id="staticText3" style="left: 24px; top: 72px; position: absolute" text="Current Percentage"/>
                        <ui:textArea binding="#{TakeTest.question}" id="question" style="height: 48px; left: 24px; top: 120px; position: absolute; width: 288px"/>
                        <ui:staticText binding="#{TakeTest.staticText4}" id="staticText4" style="left: 24px; top: 96px; position: absolute" text="Question"/>
                        <ui:radioButtonGroup binding="#{TakeTest.answer}" id="answer" items="#{TakeTest.answerDefaultOptions.options}"
                            style="left: 24px; top: 192px; position: absolute" validator="#{TakeTest.answer_validate}" valueChangeListener="#{TakeTest.answer_processValueChange}"/>
                        <ui:textField binding="#{TakeTest.questionNum}" id="questionNum" style="left: 144px; top: 48px; position: absolute; width: 48px"/>
                        <ui:textField binding="#{TakeTest.percentage}" id="percentage" style="left: 144px; top: 72px; position: absolute; width: 48px"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
