<template>
  <v-app app style="background: #222222" class="overflow-hidden">
      <v-card>
        <v-app-bar
        app
        absolute
        dark
        hide-on-scroll
        prominent
        src="..\public\wall-paper-rov.jpg"
        scroll-target="#scrolling-techniques-4"
      >
        <v-toolbar-title class="text-uppercase">
          <div>
            <img src="..\public\img-logo-rov.png" />
          </div>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      </v-app-bar>
      </v-card>
      
    <v-card>
      <v-navigation-drawer v-model="drawer" absolute temporary app right src="..\public\img3.jpg">
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title
              class="application text-center white--text"
              style="margin-right: 15px;"
              v-if="login()"
            >{{name}}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <v-list>
          <v-list-item
            v-for="link in links"
            :key="link.text"
            router
            :to="link.route"
            active-class="border"
          >
            <v-list-item-avatar size="30">
              <v-img :src="link.avatar"></v-img>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title class=" white--text">{{link.text}}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
        
        <template v-slot:append>
          <div class="text-center pa-2">
            <v-btn
              v-if="logoutb()"
              dark
              outlined
              class="text-center mb-6"
              target="_self"
              @click="logout"
            >
              LOGOUT
              <v-icon right>exit_to_app</v-icon>
            </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
    </v-card>
    <v-content >
      <router-view  />
    </v-content>
    
    <v-footer dark padless>
      <v-col class="text-center font-weight-light" cols="12">
        &copy;{{ new Date().getFullYear() }} —
        <strong>Nattapol Panta B6015107</strong>
      </v-col>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      name: "",
      id: "",
      valid: false,
      drawer: null,
      links: [
        { avatar: "..\\home.png", text: "HOME", route: "/home" },
        { avatar: "..\\hero.png", text: "HEROES", route: "/characterList" },
        { text: "SKIN",  route: "/skinList" },
        { avatar: "..\\enchanment.png", text: "ENCHANTMENT", route: "/enchantment"},
        { avatar: "..\\item.png", text: "ITEM", route: "/item" },
        { avatar: "..\\mode.png", text: "MODE",  route: "/modeList" },
        { avatar: "..\\rune.png", text: "RUNE", route: "/rune" },
      ],
    };
  },
  methods: {
    login() {
      this.name = localStorage.getItem("Name");
      return (
        this.$router.history.current["path"] !== "/signup" &&
        this.$router.history.current["path"] !== "/"
      );
    },
    logoutb() {
      return (
        this.$router.history.current["path"] !== "/signup" &&
        this.$router.history.current["path"] !== "/"
      );
    },
    menu() {
      return (
        this.$router.history.current["path"] !== "/" &&
        this.$router.history.current["path"] !== "/menu"
      );
    },
    logout() {
      localStorage.removeItem("Name");
      localStorage.removeItem("Id");
      this.$router.push("/");
    },
  },
};
</script>
<style>
/* Helper classes */
.basil--text {
  color: #356859 !important;
}
</style>