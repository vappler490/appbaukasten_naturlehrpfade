<template>
    <Page class="page">
        <ActionBar class="action-bar">
            <!--
            Use the NavigationButton as a side-drawer button in Android
            because ActionItems
             Items
             5are shown on the right side of the ActionBar
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
            <Label class="action-bar-title" text="Liste"></Label>
        </ActionBar>

        <GridLayout class="page__content">
<!--    //$navigateTo(detailPage),         <button text="Hole Daten" @tap="getData"></button>
            <Label class="page__content-icon fas" text.decode="&#xf005;"></Label>
            <Label class="page__content-placeholder" :text="message"></Label> -->
            <ListView for="item in this.$store.getters.pois" class="list-group">
                <v-template>
                    <GridLayout class="list-group-item" rows="auto, auto" columns="50, *">
                        <Label row="0" col="1" @tap="setDataStore(item)">{{ item.name }}</Label>
                        <Label :text="item.poiId" row="1" col="1" />

                    </GridLayout>
                </v-template>
            </ListView>

        </GridLayout>
    </Page>
</template>

<script>
    import * as utils from "~/shared/utils";
    import SelectedPageService from "../shared/selected-page-service";
    import * as http from "tns-core-modules/http";
    import DetailPage from  "./DetailPage";
    export default {
        data() {
            return{
                htmlString:  this.$store.getters.htmlData,
                detailPage: {
   template: `
    <Page>
      <ActionBar title="Detail"/>
      <StackLayout>
        <Button @tap="$navigateBack" text="Close" />
        <WebView :src="filePath" @loadFinished="onWebViewLoaded" />
      </StackLayout>
    </Page>
  `
}
            }

        },

        mounted() {
            SelectedPageService.getInstance().updateSelectedPage("List");
        },
        computed: {
            message() {
                return "<!-- Page content goes here -->";
            }
        },
        data() {
            return {
                projectName : this.$store.getters.getProjectName
            }
        },
        components: {
            DetailPage
        },
        methods: {
             setDataStore(htmlData) {

                this.$store.commit('changeHtmlData', htmlData)
                this.$navigateTo(DetailPage)


            },
        onWebViewLoaded (event) {
            if (event.error) {
                console.log(error)
            } else {
                console.log('webview loaded')
            }
        },

            onDrawerButtonTap() {
                utils.showDrawer();
            }
        }
    };
</script>

<style scoped lang="scss">
    // Start custom common variables
    @import '~@nativescript/theme/scss/variables/blue';
    // End custom common variables

    // Custom styles
</style>
