<template lang="html">
    <GridLayout rows="auto, *" class="nt-drawer__content">
        <StackLayout row="0" class="nt-drawer__header">
            <Label class="nt-drawer__header-brand" text="Naturlehrpfad"></Label>
            <DropDown horizontalAlignment="center" itemsTextAlignment="center" class="dropDown" :items="listOfItems"
                      :hint="headerHint"
                      @selectedIndexChanged="selectProject($event)"></DropDown>
        </StackLayout>

        <ScrollView row="1" class="nt-drawer__body">
            <StackLayout>
                <GridLayout columns="auto, *"
                            :class="'nt-drawer__list-item' + (selectedPage === 'Home' ? ' -selected': '')"
                            @tap="onNavigationItemTap(Home)">
                    <Label col="0" text.decode="&#xf015;" class="nt-icon fas"></Label>
                    <Label col="1" text="Home" class="p-r-10"></Label>
                </GridLayout>

                <GridLayout columns="auto, *"
                            :class="'nt-drawer__list-item' + (selectedPage === 'MapView' ? ' -selected': '')"
                            @tap="onNavigationItemTap(MapView)">
                    <Label col="0" text.decode="&#xf1ea;" class="nt-icon far"></Label>
                    <Label col="1" text="Map" class="p-r-10"></Label>
                </GridLayout>

                <GridLayout columns="auto, *"
                            :class="'nt-drawer__list-item' + (selectedPage === 'List' ? ' -selected': '')"
                            @tap="onNavigationItemTap(List)">
                    <Label col="0" text.decode="&#xf005;" class="nt-icon fas"></Label>
                    <Label col="1" text="Liste" class="p-r-10"></Label>
                </GridLayout>

                <StackLayout class="hr"></StackLayout>

            </StackLayout>
        </ScrollView>
    </GridLayout>
</template>

<script>
    import Home from "./Home";
    import MapView from "./MapView";
    import List from "./List";
    import * as utils from "~/shared/utils";
    import SelectedPageService from "~/shared/selected-page-service";
    import * as http from "tns-core-modules/http";
    import DetailPage from "~/components/DetailPage";

    export default {
        mounted() {
            SelectedPageService.getInstance().selectedPage$
                .subscribe((selectedPage) => this.selectedPage = selectedPage);
            this.getProjects();
        },
        data() {
            return {
                listOfItems: [],
                headerHint: "Wählen Sie einen Pfad aus",
                Home: Home,
                MapView: MapView,
                List: List,
                selectedPage: ""
            };
        },
        components: {
            Home,
            MapView,
            List,
        },
        methods: {
            onNavigationItemTap(component) {
                this.$navigateTo(component, {
                    clearHistory: true
                });
                utils.closeDrawer();
            },
            getProjects() {
                http.getJSON("http://10.0.2.2:8085/projects").then(result => {
                    var i;
                    for (i = 0; i <= result.length; i++) {
                        this.listOfItems[i] = result[i].name;
                    }
                })

            },
            getProject() {

            },
            selectProject(selectedIndexEvent) {
                this.$store.commit("changeProjectName", this.listOfItems[selectedIndexEvent.newIndex])
                this.getPois(this.listOfItems[selectedIndexEvent.newIndex])
            },
            getPois(projectName) {
                http.getJSON("http://10.0.2.2:8085/pois?project=" + projectName).then(result => {
                    let pois = result;
                    for (let i = 0; i < pois.length; i++) {
                        pois[i].lat = pois[i].latLng.lat
                        pois[i].lng = pois[i].latLng.lng
                        pois[i].title = pois[i].name
                        pois[i].selected = false
                        pois[i].onCalloutTap =() => {
                            this.$store.commit("changeHtmlData", "pois[i].htmlData"), this.$navigateTo(DetailPage), console.log("hallo")
                        }
                    }
                    this.$store.commit("changePois", pois)
                })
            },
        }
    };
</script>

<style scoped lang="scss">
    // Start custom common variables
    @import '~@nativescript/theme/scss/variables/blue';
    // End custom common variables

    // Custom styles
</style>
