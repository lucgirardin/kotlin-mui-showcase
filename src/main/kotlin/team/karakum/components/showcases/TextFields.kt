package team.karakum.components.showcases

import csstype.Display
import csstype.JustifyContent
import mui.material.*
import mui.material.DividerVariant.fullWidth
import mui.material.FormControlVariant.*
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.dom.html.ReactHTML.form

val TextFieldsShowcase = FC<Props> {
    Box {
        sx {
            display = Display.grid
            justifyContent = JustifyContent.left
        }
        component = form
        // TODO: Unable to set `noValidate` & `autoComplete` props correctly [MUI]
        asDynamic().noValidate = true
        asDynamic().autoComplete = "off"

        Divider {
            variant = fullWidth

            Chip {
                label = ReactNode("Text Fields")
            }
        }

        TextField {
            id = "outlined-basic"
            label = ReactNode("Outlined")
            variant = outlined
        }
        TextField {
            id = "filled-basic"
            label = ReactNode("Filled")
            variant = filled
        }
        TextField {
            id = "standard-basic"
            label = ReactNode("Standard")
            variant = standard
        }

        Divider {
            variant = fullWidth

            Chip {
                label = ReactNode("Base Inputs")
            }
        }

        Input {
            defaultValue = "Hello World"
        }
        Input {
            placeholder = "Placeholder"
        }
        Input {
            defaultValue = "Disabled"
            disabled = true
        }
        Input {
            defaultValue = "Error"
            error = true
        }
    }
}
