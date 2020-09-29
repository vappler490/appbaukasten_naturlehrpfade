<template>
    <Page >
        <ActionBar title="POI-Detailseite">
          <NavigationButton text="Zurück" android.systemIcon="ic_menu_back" @tap="$navigateBack"></NavigationButton>
        </ActionBar>
        <GridLayout>
             <WebView  row="0" col="0"
            :src="filePath" />
        </GridLayout>
    </Page>
</template>

<script>
import * as fs from "tns-core-modules/file-system";
import * as utils from "utils/utils";



  export default {
    data() {
      return {
        filePath: this.$store.getters.htmlData,
      }
    },
    methods: {

        }
    }
  ;
</script>
