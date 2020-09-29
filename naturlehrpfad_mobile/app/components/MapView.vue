<template>
    <Page class="page">
        <ActionBar class="action-bar">
            <!--
            Use the NavigationButton as a side-drawer button in Android
            because ActionItems are shown on the right side of the ActionBar
            -->
            <NavigationButton ios:visibility="collapsed" icon="res://menu" @tap="onDrawerButtonTap"></NavigationButton>
            <!--
            Use the ActionItem for IOS with position set to left. Using the
            NavigationButton as a side-drawer button in iOS is not possible,
            because its function is to always navigate back in the application.
            -->
            <ActionItem icon="res://menu"
                android:visibility="collapsed"
                @tap="onDrawerButtonTap"
                ios.position="left">
            </ActionItem>
            <Label class="action-bar-title" text="Map"></Label>
        </ActionBar>



        <GridLayout class="page__content">
            <Label class="page__content-icon far" text.decode="&#xf1ea;"></Label>
            <Label class="page__content-placeholder" :text="message"></Label>
            <Mapbox
            :accessToken="token"
            :latitude="51.05728464934729"
            :longitude="13.734417431081429"
            :hideCompass="true"
            :zoomLevel="14"
            :mapReady="onMapReady()"
            ref="map"
            ></Mapbox>
        </GridLayout>

    </Page>
</template>

<script>
    import * as utils from "~/shared/utils";
    import SelectedPageService from "../shared/selected-page-service";
    import * as Mapbox from "nativescript-mapbox";
    import DetailPage from "~/components/DetailPage";

    export default {
        mounted() {
            SelectedPageService.getInstance().updateSelectedPage("Map");
        },
        data() {
            return {
                token:"pk.eyJ1IjoiYWhzYWxsZXBhc3NpIiwiYSI6ImNrM24zM2FtODE2bGozbnF4OHQ2eGxheHIifQ.QBWQUI-QsAHP4naKyggasA"
            }
        },
        computed: {
            message() {
                return "<!-- Page content goes asdasd -->";
            }
        },
        methods: {
            onMapReady: function () {
                var vm = this;
                setTimeout(function () {
                    vm.addMarker();
                },1000);
            },
            addMarker: function (){
                this.$refs.map.nativeView.addMarkers(
                    this.$store.getters.pois
            );
            },
            onDrawerButtonTap() {
                utils.showDrawer();
            },
            setDataStore(poi) {

                this.$store.commit('changeHtmlData', poi.htmlData)
                this.$navigateTo(DetailPage)


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
