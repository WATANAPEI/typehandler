# 開発用コンテナなのでubuntuでええやろ
FROM mcr.microsoft.com/devcontainers/java:0-17

# 開発環境に必要なパッケージなどはここでインストールしておきます
# gitはGitHub Codespacesで必須です
# curlも次のステップで使うので必須です
RUN apt update && apt install -y \
    git \
    curl \
    vim \
    htop \
    jq

# Docker from DockerするためにDockerをインストールします
RUN curl -fsSL https://get.docker.com | sh

# たとえばNode.jsのプロジェクトならここで開発用コンテナにもインストールしておく
RUN curl -Ls https://deb.nodesource.com/setup_18.x | bash
RUN apt update && apt install -y nodejs

# この二行なくてもdevcontainer.jsonのforwardPortsが優先されるのかもしれないけど一応書いてる
EXPOSE 30000
EXPOSE 50000

# 実際に開発に使うroot以外のユーザーを作成します
RUN useradd -m user

# dockerコマンドを上記のroot以外のユーザーでも使えるようにするためにグチャグチャやってます
ARG NONROOT_USER=user
RUN echo "#!/bin/sh\n\
    sudoIf() { if [ \"\$(id -u)\" -ne 0 ]; then sudo \"\$@\"; else \"\$@\"; fi }\n\
    SOCKET_GID=\$(stat -c '%g' /var/run/docker.sock) \n\
    if [ \"${SOCKET_GID}\" != '0' ]; then\n\
        if [ \"\$(cat /etc/group | grep :\${SOCKET_GID}:)\" = '' ]; then sudoIf groupadd --gid \${SOCKET_GID} docker-host; fi \n\
        if [ \"\$(id ${NONROOT_USER} | grep -E \"groups=.*(=|,)\${SOCKET_GID}\(\")\" = '' ]; then sudoIf usermod -aG \${SOCKET_GID} ${NONROOT_USER}; fi\n\
    fi\n\
    exec \"\$@\"" > /usr/local/share/docker-init.sh \
    && chmod +x /usr/local/share/docker-init.sh

ENTRYPOINT [ "/usr/local/share/docker-init.sh" ]
CMD [ "sleep", "infinity" ]