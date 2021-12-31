import csstype.Display
import csstype.px
import kotlinext.js.jso
import kotlinx.browser.document
import mui.system.Box
import org.w3c.dom.HTMLDivElement
import react.FC
import react.Props
import react.create
import react.dom.render
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import react.useMemo
import showcase.*

fun main() {
    val container = document.createElement("div").unsafeCast<HTMLDivElement>().apply {
        style.minHeight = "100vh"
        style.display = "flex"
        style.flexDirection = "column"

        document.body!!.appendChild(this)
    }
    render(App.create(), container)
}

private val App = FC<Props> {
    val showcases = useMemo {
        listOf(
            ShowcaseInfo("accordion", "Accordion", AccordionShowcase),
            ShowcaseInfo("alert", "Alert", AlertShowcase),
            ShowcaseInfo("app-bar", "App Bar", AppBarShowcase),
            ShowcaseInfo("autocomplete", "Autocomplete", AutocompleteShowcase),
            ShowcaseInfo("avatar", "Avatar", AvatarShowcase),
            ShowcaseInfo("backdrop", "Backdrop", BackdropShowcase),
            ShowcaseInfo("badge", "Badge", BadgeShowcase),
            ShowcaseInfo("bottom-navigation", "Bottom Navigation", BottomNavigationShowcase),
            ShowcaseInfo("breadcrumbs", "Breadcrumbs", BreadcrumbsShowcase),
            ShowcaseInfo("button", "Button", ButtonShowcase),
            ShowcaseInfo("card", "Card", CardShowcase),
            ShowcaseInfo("checkbox", "Checkbox", CheckboxShowcase),
            ShowcaseInfo("chip", "Chip", ChipShowcase),
            ShowcaseInfo("dialog", "Dialog", DialogShowcase),
            ShowcaseInfo("drawer", "Drawer", DrawerShowcase),
            ShowcaseInfo("fab", "Fab", FabShowcase),
            ShowcaseInfo("image-list", "Image List", ImageListShowcase),
            ShowcaseInfo("input", "Input", InputShowcase),
            ShowcaseInfo("linear-progress", "Linear Progress", LinearProgressShowcase),
            ShowcaseInfo("link", "Link", LinkShowcase),
            ShowcaseInfo("list", "List", ListShowcase),
            ShowcaseInfo("menu", "Menu", MenuShowcase),
            ShowcaseInfo("mobile-stepper", "Mobile Stepper", MobileStepperShowcase),
            ShowcaseInfo("pagination", "Pagination", PaginationShowcase),
            ShowcaseInfo("paper", "Paper", PaperShowcase),
            ShowcaseInfo("popover", "Popover", PopoverShowcase),
            ShowcaseInfo("popper", "Popper", PopperShowcase),
            ShowcaseInfo("radio", "Radio", RadioShowcase),
            ShowcaseInfo("rating", "Rating", RatingShowcase),
            ShowcaseInfo("select", "Select", SelectShowcase),
            ShowcaseInfo("skeleton", "Skeleton", SkeletonShowcase),
            ShowcaseInfo("slider", "Slider", SliderShowcase),
            ShowcaseInfo("snackbar", "Snackbar", SnackbarShowcase),
            ShowcaseInfo("stepper", "Stepper", StepperShowcase),
            ShowcaseInfo("switch", "Switch", SwitchShowcase),
            ShowcaseInfo("table", "Table", TableShowcase),
            ShowcaseInfo("tabs", "Tabs", TabsShowcase),
            ShowcaseInfo("text-field", "Text Field", TextFieldShowcase),
            ShowcaseInfo("toggle-button", "Toggle Button", ToggleButtonShowcase),
            ShowcaseInfo("tooltip", "Tooltip", TooltipShowcase),
        )
    }

    BrowserRouter {

        Box {
            sx = jso {
                display = Display.flex
            }

            Header()

            Sidebar {
                value = showcases
            }

            Routes {
                Route {
                    path = "/"
                    element = Showcase.create()

                    showcases.map { (key, _, component) ->
                        Route {
                            path = key
                            element = component.create()
                        }
                    }
                }
            }
        }
    }
}

data class ShowcaseInfo(
    val key: String,
    val name: String,
    val component: FC<Props>,
)

object Sizes {
    object Header {
        val Height = 64.px
    }

    object Sidebar {
        val Width = 168.px
    }
}
