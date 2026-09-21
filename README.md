# 🚘 InstaCar

Rede social automotiva — projeto inicial preparado para GitHub.

## Recursos planejados
- Cadastro e login
- Perfil e avatar
- Feed
- Publicações com fotos
- Curtidas e comentários
- Seguir usuários
- Busca
- Perfil de carro
- Notificações
- Denúncia e bloqueio
- Painel administrativo

## Arquitetura

`Android App -> API -> PostgreSQL / Storage`

O repositório contém uma base Android, uma API Node/Express e uma pasta de banco preparada para PostgreSQL.

## Configuração local

1. Instale Android Studio e Node.js.
2. Entre na pasta `backend`.
3. Rode `npm install`.
4. Copie `.env.example` para `.env`.
5. Configure a URL/chave do banco quando houver backend conectado.
6. Abra `android/` no Android Studio.

> Esta entrega é uma base de desenvolvimento. Não contém credenciais reais nem um servidor público ativo.
