package org.apache.struts2.views;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.freemarker.tags.StrutsModels;
import org.apache.struts2.views.velocity.components.ActionDirective;
import org.apache.struts2.views.velocity.components.ActionErrorDirective;
import org.apache.struts2.views.velocity.components.ActionMessageDirective;
import org.apache.struts2.views.velocity.components.AnchorDirective;
import org.apache.struts2.views.velocity.components.AutocompleterDirective;
import org.apache.struts2.views.velocity.components.BeanDirective;
import org.apache.struts2.views.velocity.components.CheckBoxDirective;
import org.apache.struts2.views.velocity.components.CheckBoxListDirective;
import org.apache.struts2.views.velocity.components.ComboBoxDirective;
import org.apache.struts2.views.velocity.components.ComponentDirective;
import org.apache.struts2.views.velocity.components.DateDirective;
import org.apache.struts2.views.velocity.components.DatePickerDirective;
import org.apache.struts2.views.velocity.components.DivDirective;
import org.apache.struts2.views.velocity.components.DoubleSelectDirective;
import org.apache.struts2.views.velocity.components.DropdownDateTimePickerDirective;
import org.apache.struts2.views.velocity.components.FieldErrorDirective;
import org.apache.struts2.views.velocity.components.FileDirective;
import org.apache.struts2.views.velocity.components.FormDirective;
import org.apache.struts2.views.velocity.components.HeadDirective;
import org.apache.struts2.views.velocity.components.HiddenDirective;
import org.apache.struts2.views.velocity.components.I18nDirective;
import org.apache.struts2.views.velocity.components.IncludeDirective;
import org.apache.struts2.views.velocity.components.LabelDirective;
import org.apache.struts2.views.velocity.components.OptionTransferSelectDirective;
import org.apache.struts2.views.velocity.components.ParamDirective;
import org.apache.struts2.views.velocity.components.PasswordDirective;
import org.apache.struts2.views.velocity.components.PropertyDirective;
import org.apache.struts2.views.velocity.components.PushDirective;
import org.apache.struts2.views.velocity.components.RadioDirective;
import org.apache.struts2.views.velocity.components.ResetDirective;
import org.apache.struts2.views.velocity.components.SelectDirective;
import org.apache.struts2.views.velocity.components.SetDirective;
import org.apache.struts2.views.velocity.components.SubmitDirective;
import org.apache.struts2.views.velocity.components.TabbedPanelDirective;
import org.apache.struts2.views.velocity.components.TextAreaDirective;
import org.apache.struts2.views.velocity.components.TextDirective;
import org.apache.struts2.views.velocity.components.TextFieldDirective;
import org.apache.struts2.views.velocity.components.TokenDirective;
import org.apache.struts2.views.velocity.components.TreeDirective;
import org.apache.struts2.views.velocity.components.TreeNodeDirective;
import org.apache.struts2.views.velocity.components.URLDirective;
import org.apache.struts2.views.velocity.components.UpDownSelectDirective;
import org.apache.struts2.views.velocity.components.WebTableDirective;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * The default Struts tag library
 */
public class DefaultTagLibrary implements TagLibrary {

    public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req,
            HttpServletResponse res) {
        
        return new StrutsModels(stack, req, res);
    }

    public List<Class> getVelocityDirectiveClasses() {
        Class[] directives = new Class[] {
            ActionDirective.class,
            BeanDirective.class,
            CheckBoxDirective.class,
            CheckBoxListDirective.class,
            ComboBoxDirective.class,
            ComponentDirective.class,
            DateDirective.class,
            DatePickerDirective.class,
            DropdownDateTimePickerDirective.class,
            DivDirective.class,
            AutocompleterDirective.class,
            DoubleSelectDirective.class,
            FileDirective.class,
            FormDirective.class,
            HeadDirective.class,
            HiddenDirective.class,
            AnchorDirective.class,
            I18nDirective.class,
            IncludeDirective.class,
            LabelDirective.class,
            ParamDirective.class,
            PasswordDirective.class,
            PushDirective.class,
            PropertyDirective.class,
            RadioDirective.class,
            SelectDirective.class,
            SetDirective.class,
            SubmitDirective.class,
            ResetDirective.class,
            TabbedPanelDirective.class,
            TextAreaDirective.class,
            TextDirective.class,
            TextFieldDirective.class,
            TokenDirective.class,
            TreeDirective.class,
            TreeNodeDirective.class,
            URLDirective.class,
            WebTableDirective.class,
            ActionErrorDirective.class,
            ActionMessageDirective.class,
            FieldErrorDirective.class,
            OptionTransferSelectDirective.class,
            UpDownSelectDirective.class
        };
        return Arrays.asList(directives);
    }

}
