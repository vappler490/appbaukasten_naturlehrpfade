<template>
  <div>
    <v-app>
      <v-content>
        <v-row class="pt-5">
          <v-spacer></v-spacer>
          <v-card min-height="80%">
            <v-card-title class="justify-center">Karte</v-card-title>
            <v-col>
              <v-row>
                <v-col>
                  <v-text-field
                    v-model="projectName"
                    :counter="50"
                    label="Projektname"
                    required
                  ></v-text-field>
                </v-col>
                <v-col>
                  <v-select
                    style="max-width: 240.88px"
                    :items="this.$store.getters.projects"
                    v-model="this.$store.getters.currentProject"
                    @change="SelectProject"
                    item-text="name"
                    item-value="projectId"
                    label="Projekt"
                  >
                  </v-select>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <v-btn @click="createProject(projectName)">Erstellen </v-btn>
                </v-col>
                <v-col>
                  <v-btn v-if="!this.$store.getters.currentProject" disabled
                    >Kartenzentrum setzen</v-btn
                  >
                  <v-btn v-else>Zentrum neu setzen</v-btn>
                </v-col>
              </v-row>
              <LeafMap></LeafMap>
            </v-col>
          </v-card>
          <v-spacer></v-spacer>
          <v-card>
            <v-card-title class="justify-center">Editor</v-card-title>
            <v-col>
              <v-row>
                <v-col>
                  <v-select
                    style="max-width: 305.6px; min-width: 305.6px"
                    :items="this.$store.getters.pois"
                    @change="selectPoi"
                    item-text="name"
                    item-value="poiId"
                    label="Stationsname"
                  >
                  </v-select>
                </v-col>
                <v-col align-self="center">
                  <v-btn
                    v-if="this.$store.getters.poiIsSelected"
                    v-on:click="previewPoi"
                  >
                    POI Vorschau
                  </v-btn>
                  <v-btn v-else disabled v-on:click="previewPoi">
                    POI Vorschau
                  </v-btn>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <v-btn
                    class="mr-4"
                    v-if="
                      this.$store.getters.poiIsStored &&
                        this.$store.getters.poiIsSelected
                    "
                    v-on:click="updateData"
                    >POI Speichern</v-btn
                  >
                  <v-btn
                    class="mr-4"
                    v-else-if="
                      this.$store.getters.poiIsStored &&
                        !this.$store.getters.poiIsSelected
                    "
                    disabled
                    v-on:click="updateData"
                    >POI Speichern</v-btn
                  >
                  <v-btn
                    class="mr-4"
                    v-else-if="
                      !this.$store.getters.poiIsStored &&
                        !this.$store.getters.poiIsSelected
                    "
                    disabled
                    v-on:click="storeData"
                    >POI Speichern</v-btn
                  >
                  <v-btn class="mr-4" v-else v-on:click="storeData"
                    >POI Speichern</v-btn
                  >
                </v-col>
                <v-col>
                  <v-btn
                    v-if="this.$store.getters.poiIsSelected"
                    v-on:click="deletePoi"
                    class="mr-4"
                    style="margin-left: 64px"
                    >POI Löschen</v-btn
                  >

                  <v-btn
                    v-else
                    disabled
                    style="margin-left: 64px"
                    v-on:click="deletePoi"
                    class="mr-4"
                    >POI Löschen</v-btn
                  >
                </v-col>
              </v-row>
              <Editor
                class="editor"
                style="height: 100vh; width: 61vh;"
                :key="this.$store.getters.poi.htmlData"
              ></Editor>
            </v-col>
          </v-card>
          <v-spacer></v-spacer>
          <v-card min-width="25%" width="15%">
            <v-card-title class="justify-center">Vorschau</v-card-title>
            <v-col>
              <v-row>
                <v-col align-self="end">
                  <div style="min-height: 16px"></div>
                  <v-btn v-if="this.$store.getters.currentProject" align="end"
                    >Projekt löschen</v-btn
                  >
                  <v-btn v-else disabled align="end">Projekt löschen</v-btn>
                </v-col>
              </v-row>
              <v-row>
                <v-col align-self="end">
                  <div style="min-height: 16px"></div>
                  <v-btn
                    v-if="this.$store.getters.currentProject"
                    align-self="end"
                  >
                    Projekt veröffentlichen</v-btn
                  >
                  <v-btn v-else disabled align-self="end">
                    Projekt veröffentlichen</v-btn
                  >
                </v-col>
              </v-row>
              <v-card>
                <span v-html="this.$store.getters.htmlData"></span>
              </v-card>
            </v-col>
          </v-card>
          <v-spacer></v-spacer>
        </v-row>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import L from "leaflet";
import Editor from "../components/Editor";
import LeafMap from "../components/LeafMap";
import axios from "axios";
import { bus } from "../main";
export default {
  name: "Project",
  components: {
    Editor,
    LeafMap
  },
  data() {
    return {
      projectName: "",
      project: this.$store.getters.project
    };
  },
  created: function() {
    this.getProjects();
    //this.getPois();
  },
  methods: {
    previewPoi() {
      bus.$emit("preview");
    },
    getPois(project) {
      axios.get("/pois?project=" + project).then(response => {
        this.$store.commit("getPois", response.data);
      });
    },
    getProjects() {
      axios.get("/projects").then(response => {
        this.$store.commit("getProjects", response.data);
      });
    },
    selectPoi(poiId) {
      this.$store.commit("changeId", poiId);
      var poi = this.$store.getters.pois.filter(obj => {
        return obj.poiId === poiId;
      });
      this.$store.commit("changePoi", poi[0]);
      this.$store.commit("changeHtmlData", poi[0].htmlData);
      this.$store.commit("changePoiIsSelected", true);
    },
    SelectProject(projectId) {
      var project = this.$store.getters.projects.filter(obj => {
        return obj.projectId === projectId;
      });
      this.$store.commit("changeCurrentProject", project[0]);
      this.$store.commit("changeCenter", project[0].center);
      this.$store.commit("changeCenterIsSet", true);
      this.$store.commit("changeZoom", parseInt(project[0].zoom));
      this.getPois(project[0].name);
    },
    createProject(projectName) {
      let project = {
        projectId: this.$store.getters.projects.length + 1,
        name: projectName,
        center: L.latLng(
          this.$store.getters.center[0],
          this.$store.getters.center[1]
        ),
        zoom: this.$store.getters.zoom
      };
      this.$store.commit("addProject", project);
      this.$store.commit("changeCurrentProject", project);
      this.saveProject();
    },
    saveProject() {
      axios.post("/projects", this.$store.getters.currentProject);
    },
    storeData() {
      axios.post("/pois", this.$store.getters.poi);
      this.$store.commit("changePoiIsStored", true);
    },
    updateData() {
      axios.put(
        "pois/" + this.$store.getters.poi.poiId,
        this.$store.getters.poi
      );
    },
    deletePoi() {
      axios.delete(
        "pois/delete/" + this.$store.getters.poi.poiId,
        this.$store.getters.poi
      );
    }
  }
};
</script>

<style scoped></style>
