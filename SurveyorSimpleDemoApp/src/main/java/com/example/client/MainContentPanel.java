package com.example.client;

/*
 * #%L
 * SurveyorSimpleDemoApp
 * %%
 * Copyright (C) 2013 - 2014 University of Oxford
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the University of Oxford nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.wwarn.surveyor.client.mvp.view.MainPanelView;

/**
 * Panel for surveyor, uses UIBinder to make distinction between layout and style clearer
 * User: nigel
 * Date: 30/07/13
 * Time: 10:13
 */
public class MainContentPanel extends Composite implements MainPanelView {
    interface MainPanelUiBinder extends UiBinder<Widget, MainContentPanel> {
    }

    @UiField(provided = true)
    FlowPanel filterContainerPanel = new FlowPanel();

    @UiField(provided = true)
    FlowPanel resultsContainerPanel = new FlowPanel();

    private static MainPanelUiBinder uiBinder = GWT.create(MainPanelUiBinder.class);

    public MainContentPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        filterContainerPanel.getElement().setId("sidebar");
        RootPanel.get("mainContent").add(this);
        setupSideBarInteraction();
    }

    public static native void setupSideBarInteraction() /*-{
        var $ = $wnd.$;

        $($wnd.document).ready(function() {
            $('a.wwarnFilterContainerToggle').click(function(e) {
                $wnd.console.log(e);
                e.preventDefault()
                if ($.trim($(".buttonLabel", this).text()) === 'Hide filters') {
                    $(".buttonLabel", this).text('Show filters');
                } else {
                    $(".buttonLabel", this).text('Hide filters');
                }
                $('.row-offcanvas').toggleClass('active');
            });
        });
    }-*/;

    /**
     * Get filter panel this is used in controller to setup filters
     * @return
     */
    public FlowPanel getFilterContainerPanel() {
        return filterContainerPanel;
    }

    public FlowPanel getResultsContainerPanel() {
        return resultsContainerPanel;
    }

}